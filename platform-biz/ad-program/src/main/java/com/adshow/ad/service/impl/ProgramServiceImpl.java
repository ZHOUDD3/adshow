package com.adshow.ad.service.impl;

import com.adshow.ad.entity.*;
import com.adshow.ad.mapper.ProgramMapper;
import com.adshow.ad.param.ProgramParam;
import com.adshow.ad.service.IProgramMaterialService;
import com.adshow.ad.service.IProgramService;
import com.adshow.ad.service.ISubtitleService;
import com.adshow.common.FileTypes;
import com.adshow.common.StorageProperties;
import com.adshow.core.common.Param.ImgEntity;
import com.adshow.ad.utils.ThumbnailsUtil;
import com.adshow.core.common.utils.SnowFlakeUtil;
import com.adshow.palyer.service.IPlayerProgramService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.adshow.common.FileTypes.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-08-03
 */
@Service
public class ProgramServiceImpl extends ServiceImpl<ProgramMapper, Program> implements IProgramService {

    private static final Logger log = LoggerFactory.getLogger(ProgramServiceImpl.class);

    @Value("${module.program.thumbnails.backpath}")
    private String backImgPath;

    @Value("${module.program.thumbnails.width}")
    private Integer thumbnailWidth;

    @Value("${module.program.thumbnails.height}")
    private Integer thumbnailHeight;

    @Value("${module.file.rootPath}")
    private String fileRootPath;

    @Autowired
    private IProgramMaterialService programMaterialService;

    @Autowired
    private IPlayerProgramService playerProgramService;

    @Autowired
    private ISubtitleService subtitleService;

    protected IPlayerProgramService getPlayerProgramService(){
        return  playerProgramService;
    }

    protected IProgramMaterialService getProgramMaterialService(){
        return  programMaterialService;
    }


    @Async
    @Override
    public void processThumbnails(List<ProgramMaterial> programMaterials,String programId) throws IOException {
        log.info("@Async processThumbnails  begin ...");
        List<ImgEntity> list = new ArrayList<>();
        ImgEntity backImg = new ImgEntity();
        backImg.setImgPath(StorageProperties.FILE_ROOT_PATH+backImgPath);
        list.add(backImg);

        if(programMaterials!=null && !programMaterials.isEmpty()){
            programMaterials.sort(Comparator.comparingInt(o -> (o.getMaterialOder() != null ? o.getMaterialOder() : 0)));
            for (ProgramMaterial pm:programMaterials ) {
                FileTypes type = valueOf(pm.getType());
                if(type != null && (type.equals(VIDEO) || type.equals(PICTURE))){
                    ImgEntity img = new ImgEntity();
                    img.setSize(new Integer[]{pm.getWidth(),pm.getHeight()});
                    img.setLocation(new Integer[]{pm.getPositionX(),pm.getPositionY()});
                    String path = fileRootPath  + valueOf(pm.getType()) +   System.getProperty("file.separator") + pm.getMaterialId()
                            + System.getProperty("file.separator");

                    switch (valueOf(pm.getType())){

                        case VIDEO :
                            path = path + pm.getMaterialName().substring(0,pm.getMaterialName().lastIndexOf("."))+".jpg";
                            break;
                        case PICTURE:
                            path = path + pm.getMaterialName();
                            break;
                    }
                    img.setImgPath(path);
                    list.add(img);
                }

            }
        }

        Path secondPath = Paths.get(fileRootPath ,PROGRAM.toString());
        if(!Files.exists(secondPath)){
            Files.createDirectories(secondPath);
        }
        String savedPath = fileRootPath + PROGRAM + System.getProperty("file.separator") + programId+".jpg";
        ThumbnailsUtil.programBuild(new Integer[]{thumbnailWidth,thumbnailHeight},savedPath,list.toArray(new ImgEntity[list.size()]));


    }

    @Override
    public ProgramParam getProgramParamById(String programId) {

        ProgramParam programParam = new ProgramParam();
        Wrapper<ProgramMaterial> wrapper = new EntityWrapper<>();
        wrapper.eq("program_id",programId);
        programParam.setMaterials(getProgramMaterialService().selectList(wrapper));
        Wrapper<Subtitle> subtitleWrapper = new EntityWrapper<>();
        subtitleWrapper.eq("program_id",programId);
        programParam.setSubtitles(getSubtitleService().selectList(subtitleWrapper));
        Wrapper<PlayerProgram> playerWrapper = new EntityWrapper<>();
        playerWrapper.eq("program_id",programId);
        List<PlayerProgram> playerPrograms = getPlayerProgramService().selectList(playerWrapper);
        if(playerPrograms!=null && playerPrograms.size()>0){
            List<Player> players = new ArrayList<>();
            for (PlayerProgram pp:playerPrograms ) {
                Player player = new Player();
                player.setId(pp.getId());
                player.setName(pp.getPlayerName());
                players.add(player);
            }
            programParam.setPlayIds(players);
        }

        return programParam;
    }

    @Override
    public void creat(ProgramParam entity) throws IOException {

        Program program = new Program();
        program.setName(entity.getName());
        program.setDateShow(entity.getDateShow());
        program.setMusicIds(entity.getMusicIds());
        program.setPreviewImage(entity.getPreviewImage());
        program.setProgramDescription(entity.getProgramDescription());
        program.setProgramDuration(entity.getProgramDuration());
        program.setTemplateImage(entity.getTemplateImage());
        program.setType(entity.getType());
        program.setTextIds(entity.getTextIds());
        program.setVideoIds(entity.getVideoIds());
        program.setWeather(entity.getWeather());

        this.insert(program);
        List<ProgramMaterial> materials = entity.getMaterials();
        for (ProgramMaterial pm:materials) {
            pm.setId( String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId()));
            pm.setProgramId(program.getId());
        }
        getProgramMaterialService().insertBatch(materials);

        List<Subtitle> subtitles = entity.getSubtitles();
        for (Subtitle subtitle:subtitles) {
            subtitle.setId( String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId()));
            subtitle.setProgramId(program.getId());
        }
        getSubtitleService().insertBatch(subtitles);

        List<Player> playerIds = entity.getPlayIds();
        if(playerIds!=null && !playerIds.isEmpty()){
            List<PlayerProgram> playerPrograms = new ArrayList<>();
            for (Player player: playerIds) {
                PlayerProgram pp = new PlayerProgram();
                pp.setPlayerId(player.getId());
                pp.setPlayerName(player.getName());
                pp.setProgramId(program.getId());
                pp.setProgramName(entity.getName());
                playerPrograms.add(pp);
            }
            getPlayerProgramService().insertBatch(playerPrograms);
        }
        this.processThumbnails(materials,program.getId());

    }


    public ISubtitleService getSubtitleService() {
        return subtitleService;
    }
}
