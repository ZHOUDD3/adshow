package com.adshow.ad.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import com.adshow.ad.entity.*;
import com.adshow.ad.mapper.ProgramMapper;
import com.adshow.ad.param.ProgramParam;
import com.adshow.ad.service.IProgramMaterialService;
import com.adshow.ad.service.IProgramService;
import com.adshow.ad.service.ISubtitleService;
import com.adshow.ad.utils.ThumbnailsUtil;
import com.adshow.common.FileTypes;
import com.adshow.common.StorageProperties;
import com.adshow.core.common.Param.ImgEntity;
import com.adshow.core.common.utils.SnowFlakeUtil;
import com.adshow.palyer.service.IPlayerProgramService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

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
            if((programMaterials.get(0).getWidth()!=null && programMaterials.get(0).getWidth().equals(1.0))
                    && (programMaterials.get(0).getHeight()!=null && programMaterials.get(0).getHeight().equals(1.0)) ){
                list.remove(0);
            }
            for (ProgramMaterial pm:programMaterials ) {
                FileTypes type = valueOf(pm.getType());
                if(type != null && (type.equals(VIDEO) || type.equals(PICTURE))){
                    ImgEntity img = new ImgEntity();
                    img.setSize(new Double[]{pm.getWidth(),pm.getHeight()});
                    img.setLocation(new Double[]{pm.getPositionX(),pm.getPositionY()});
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
        Program program = this.selectById(programId);
        program.setPreviewImage(FileTypes.PROGRAM.toString()+"/"+programId+".jpg");
        this.updateAllColumnById(program);

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
        if(subtitles!=null && subtitles.size()>0){
            for (Subtitle subtitle:subtitles) {
                subtitle.setId( String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId()));
                subtitle.setProgramId(program.getId());
            }
            getSubtitleService().insertBatch(subtitles);
        }

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


    @Override
    public void deploy(String programId, String... playerIds) {

    }


    //@Async
    public void zip(String programId) throws IOException {

        List<ADMaterial> materialList = new ArrayList<>();

        ProgramParam programParam = getProgramParamById(programId);
        List<ProgramMaterial> materials = programParam.getMaterials();

        CollectionUtils.filter(materials, new Predicate() {
            @Override
            public boolean evaluate(Object o) {
                if (o == null || !(o instanceof ProgramMaterial)) {
                    return false;
                }
                ProgramMaterial p = (ProgramMaterial) o;
                return !StringUtils.isEmpty(p.getMaterialId());
            }
        });

        Collections.sort(materials, new Comparator<ProgramMaterial>() {
            @Override
            public int compare(ProgramMaterial p1, ProgramMaterial p2) {
                return p1.getMaterialOder().compareTo(p2.getMaterialOder());
            }
        });

        StringBuilder builder = new StringBuilder();

        for (ProgramMaterial material : materials) {
            ADMaterial adm = new ADMaterial(
                    mapping.get(material.getType()),
                    material.getMaterialOder(),
                    material.getPositionY(),
                    material.getHeight() + material.getPositionY(),
                    material.getPositionX(),
                    material.getWidth() + material.getPositionX()
            );

            if (StringUtils.equals(FileTypes.VIDEO.toString(), material.getType())) {
                adm.getAttrs().put("videoPath", "/" + programId + "/" + material.getType() + "/" + material.getMaterialName());
            }
            if (StringUtils.equals(FileTypes.PICTURE.toString(), material.getType())) {
                adm.getAttrs().put("imageUrl", "/" + programId + "/" + material.getType() + "/" + material.getMaterialName());
            }
            if (StringUtils.equals(FileTypes.LOOPIMGS.toString(), material.getType())) {
                String[] itemNames = material.getMaterialName().split(",");
                builder.append("/").append(programId).append("/").append(material.getType()).append("/");
                String prefix = builder.toString();
                builder.setLength(0);
                for (String itemName : itemNames) {
                    builder.append(prefix).append(itemName).append(",");
                }
                builder.deleteCharAt(builder.length() - 1);
                adm.getAttrs().put("imageUrls", builder.toString());
            }

            materialList.add(adm);
            copyMaterial(programId, material);
        }

        List<Subtitle> Subtitles = programParam.getSubtitles();

        Collections.sort(Subtitles, new Comparator<Subtitle>() {
            @Override
            public int compare(Subtitle s1, Subtitle s2) {
                return s1.getMaterialOder().compareTo(s2.getMaterialOder());
            }
        });

        for (Subtitle subtitle : Subtitles) {
            ADMaterial adm = new ADMaterial(
                    mapping.get(String.valueOf(subtitle.getType())),
                    subtitle.getMaterialOder(),
                    subtitle.getPositionY(),
                    subtitle.getHeight() + subtitle.getPositionY(),
                    subtitle.getPositionX(),
                    subtitle.getWidth() + subtitle.getPositionX()
            );
            adm.getAttrs().put("text", subtitle.getContent());
            adm.getAttrs().put("textSize", (subtitle.getFontSize() == null || subtitle.getFontSize() == 0) ? 35 : subtitle.getFontSize());
            adm.getAttrs().put("textColor", StringUtils.isEmpty(subtitle.getFontColor()) ? "0xFFFF0000" : subtitle.getFontColor());
            materialList.add(adm);
        }

        builder.setLength(0);
        builder.append(fileRootPath)
                .append(FileTypes.PACKAGE).append(File.separator)
                .append(programId).append(File.separator).append("config.json");

        if (CollectionUtils.isNotEmpty(materialList)) {
            try (Writer writer = new FileWriter(builder.toString())) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(materialList, writer);
            }
        }

        builder.setLength(0);
        builder.append(fileRootPath)
                .append(FileTypes.PACKAGE).append(File.separator);
        String srcFolder = builder.toString() + programId;
        String destZipFile = builder.toString() + "pkg_" + programId + ".zip";
        if (FileUtil.exist(destZipFile)) {
            FileUtil.del(destZipFile);
        }
        ZipUtil.zip(srcFolder, destZipFile);
    }


    private void copyMaterial(String programId, ProgramMaterial material) {
        String[] itemIds = material.getMaterialId().split(",");
        String[] itemNames = material.getMaterialName().split(",");

        for (int i = 0; i < itemIds.length; i++) {
            copyMaterialItem(programId, material, itemIds[i], itemNames[i]);
        }
    }


    private void copyMaterialItem(String programId, ProgramMaterial material, String materialItemId, String materialItemName) {
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);
        builder.append(fileRootPath)
                .append(material.getType()).append(File.separator)
                .append(materialItemId).append(File.separator)
                .append(materialItemName);
        String srcPath = builder.toString();
        builder.setLength(0);
        builder.append(fileRootPath)
                .append(FileTypes.PACKAGE).append(File.separator)
                .append(programId).append(File.separator)
                .append(material.getType()).append(File.separator)
                .append(materialItemName);
        String destPath = builder.toString();
        FileUtil.copy(srcPath, destPath, true);
    }


    public ISubtitleService getSubtitleService() {
        return subtitleService;
    }


    private Map<String, String> mapping = new HashMap<String, String>() {{
        put("VIDEO", "com.adshow.player.widgets.ExoVideoViewWrapper");
        put("MUSIC", "com.adshow.player.widgets.ExoVideoViewWrapper");
        put("PICTURE", "com.adshow.player.widgets.ImageViewWrapper");
        put("LOOPIMGS", "com.adshow.player.widgets.ImageSliderViewWrapper");
        put("DATETIME", "com.adshow.player.widgets.DateTimeTextViewWrapper");
        put("WEATHER", "com.adshow.player.widgets.WeatherTextViewWrapper");
        put("1", "com.adshow.player.widgets.ScrollTextViewWrapper");
        put("0", "com.adshow.player.widgets.TextViewWrapper");
    }};


    public class ADMaterial {

        private String clazz;

        private int index;

        private double percentageTop;

        private double percentageBottom;

        private double percentageLeft;

        private double percentageRight;

        private Map<String, Object> attrs = new HashMap<>();

        public ADMaterial(String clazz, int index, double percentageTop, double percentageBottom, double percentageLeft, double percentageRight) {
            this.clazz = clazz;
            this.index = index;
            this.percentageTop = percentageTop;
            this.percentageBottom = percentageBottom;
            this.percentageLeft = percentageLeft;
            this.percentageRight = percentageRight;
        }

        public String getClazz() {
            return clazz;
        }

        public void setClazz(String clazz) {
            this.clazz = clazz;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public double getPercentageTop() {
            return percentageTop;
        }

        public void setPercentageTop(double percentageTop) {
            this.percentageTop = percentageTop;
        }

        public double getPercentageBottom() {
            return percentageBottom;
        }

        public void setPercentageBottom(double percentageBottom) {
            this.percentageBottom = percentageBottom;
        }

        public double getPercentageLeft() {
            return percentageLeft;
        }

        public void setPercentageLeft(double percentageLeft) {
            this.percentageLeft = percentageLeft;
        }

        public double getPercentageRight() {
            return percentageRight;
        }

        public void setPercentageRight(double percentageRight) {
            this.percentageRight = percentageRight;
        }

        public Map<String, Object> getAttrs() {
            return attrs;
        }

        public void setAttrs(Map<String, Object> attrs) {
            this.attrs = attrs;
        }
    }
}
