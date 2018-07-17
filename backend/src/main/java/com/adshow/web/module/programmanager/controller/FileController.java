package com.adshow.web.module.programmanager.controller;


import com.adshow.common.FileTypes;
import com.adshow.common.FileUploadUtil;
import com.adshow.entity.ResultInfo;
import com.adshow.exception.StorageException;
import com.adshow.web.entity.FileBaseManager;
import com.adshow.web.entity.MusicManage;
import com.adshow.web.entity.PictureManage;
import com.adshow.web.entity.VideoManage;
import com.adshow.web.module.programmanager.service.IFileService;
import org.aspectj.util.LangUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

        if(fileType ==  null ){
            throw new StorageException("Failed to store file : no expected file type in {VIDEO,MUSIC,PICTURE}" );
        }
        if(!fileType.equals(FileTypes.PICTURE.toString()) && !fileType.equals(FileTypes.MUSIC.toString()) && !fileType.equals(FileTypes.VIDEO.toString())){
            throw new StorageException("Failed to store file : no expected file type in {VIDEO,MUSIC,PICTURE}" );
        }
        String fileId = UUID.randomUUID().toString().replaceAll("-","");
        FileTypes type  ;
        if(fileType.equals(FileTypes.PICTURE)){
            type = FileTypes.PICTURE;
        }else if(fileType.equals(FileTypes.MUSIC)){
            type = FileTypes.MUSIC;
        }else {
            type = FileTypes.VIDEO;
        }

        if(FileUploadUtil.store(file,type,fileId)){
            FileBaseManager var1 = getFileInfo(file,type);
            var1.setUuid(fileId);
            var1.setPhysicalPath(type+"//"+fileId+"//"+file.getOriginalFilename());
            fileService.insert(var1);

        }
        return new ResultInfo();
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public @ResponseBody ResultInfo delete(@RequestParam("file") MultipartFile file,
                                           RedirectAttributes redirectAttributes){
        return null;
    }

    private FileBaseManager getFileInfo(MultipartFile file,FileTypes type){
        FileBaseManager fileInfo = null;
        if(type.equals(FileTypes.PICTURE)){
            type = FileTypes.PICTURE;
        }else if(type.equals(FileTypes.MUSIC)){
            type = FileTypes.MUSIC;
        }else {
            type = FileTypes.VIDEO;
            fileInfo = new VideoManage();
        }
        fileInfo.setName(file.getOriginalFilename());
        return fileInfo;
    }

}
