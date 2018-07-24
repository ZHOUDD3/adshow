package com.adshow.web.module.programmanager.controller;


import com.adshow.common.FileTypes;
import com.adshow.common.FileUploadUtil;
import com.adshow.common.MultimediaUtil;
import com.adshow.common.StorageProperties;
import com.adshow.entity.ResultInfo;
import com.adshow.exception.StorageException;
import com.adshow.module.entity.FileBaseManager;
import com.adshow.module.entity.VideoManage;
import com.adshow.web.module.programmanager.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * 素材管理类，负责素材及数据库的上传下载删除操作
 * @author wmz
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private IFileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResultInfo upload(@RequestParam("file") MultipartFile file, @RequestParam("fileType") String fileType,
                      RedirectAttributes redirectAttributes){

        FileTypes type  = FileTypes.valueOf(fileType);
        if(type ==  null ){
            throw new StorageException("Failed to store file : no expected file type in {VIDEO,MUSIC,PICTURE}" );
        }
        String fileId = UUID.randomUUID().toString().replaceAll("-","");
        String fullPath = FileUploadUtil.store(file,type,fileId);
        if(fullPath!=null){
            FileBaseManager mediaInfo  = getFileInfo(file,type,fullPath);
            mediaInfo.setUuid(fileId);
            mediaInfo.setPhysicalPath(fullPath);
            fileService.insert(mediaInfo);

        }
        return new ResultInfo();
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public @ResponseBody ResultInfo delete(@RequestParam("fileId") String fileId , @RequestParam("fileType") String fileType,
                                           RedirectAttributes redirectAttributes){
        FileTypes type  = FileTypes.valueOf(fileType);
        if(type ==  null ){
            throw new StorageException("Failed to store file : no expected file type in {VIDEO,MUSIC,PICTURE}" );
        }
        Map<String,String> param = new HashMap<>();
        param.put("uuid",fileId);
        if(fileService.deleteByMap(param)){
            FileUploadUtil.deleteFile(type,fileId);
        }
        return new ResultInfo();
    }

    private FileBaseManager getFileInfo(MultipartFile file,FileTypes type,String fileFullPath){
        FileBaseManager fileInfo = null;
        if(type.equals(FileTypes.PICTURE)){
            type = FileTypes.PICTURE;
        }else if(type.equals(FileTypes.MUSIC)){
            type = FileTypes.MUSIC;
        }else {
            type = FileTypes.VIDEO;
            VideoManage vedio = new VideoManage();
            vedio.setTimeLength(MultimediaUtil.getVideoTime(fileFullPath,StorageProperties.FFMPEG_PATH));
            fileInfo = vedio;
        }
        fileInfo.setName(file.getOriginalFilename());
        return fileInfo;
    }

}
