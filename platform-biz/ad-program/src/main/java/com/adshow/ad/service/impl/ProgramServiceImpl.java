package com.adshow.ad.service.impl;

import com.adshow.ad.entity.Program;
import com.adshow.ad.entity.ProgramMaterial;
import com.adshow.ad.mapper.ProgramMapper;
import com.adshow.ad.service.IProgramService;
import com.adshow.common.FileTypes;
import com.adshow.common.StorageProperties;
import com.adshow.core.common.Param.ImgEntity;
import com.adshow.ad.utils.ThumbnailsUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

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


}
