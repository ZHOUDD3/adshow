package com.adshow.web.module.videomanager.controller;


import com.adshow.common.FileUploadUtil;
import com.adshow.entity.ResultInfo;
import com.adshow.web.module.videomanager.entity.VideoManage;
import com.adshow.web.module.videomanager.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;


/**
 *该类负责对视频的上传和下载删除等服务
 * @author wmz
 */
@RestController()
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private IVideoService videoService;

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public @ResponseBody ResultInfo upload(@RequestParam("file") MultipartFile file,
                      RedirectAttributes redirectAttributes){
        String fileId = UUID.randomUUID().toString().replaceAll("-","");
        if(FileUploadUtil.store(file,fileId)){
            VideoManage video = new VideoManage();
            video.setAliasName(StringUtils.cleanPath(file.getOriginalFilename()));
            videoService.saveVideo(video);
        }
        return new ResultInfo();
    }

}
