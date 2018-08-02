package com.adshow.material.controller;


import com.adshow.common.FileTypes;
import com.adshow.common.FileUploadUtil;
import com.adshow.common.MultimediaUtil;
import com.adshow.common.StorageProperties;
import com.adshow.entity.BaseController;
import com.adshow.entity.ResultInfo;
import com.adshow.exception.StorageException;
import com.adshow.mapper.entity.FileBaseManager;
import com.adshow.mapper.entity.VideoManage;
import com.adshow.material.service.IFileService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
 *
 * @author wmz
 */
@Api(tags = "素材管理")
@Controller
@RequestMapping("/file")
public class FileController extends BaseController {

    @Autowired
    private IFileService fileService;

    @ApiOperation(value = "上传素材", notes = "上传素材")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "fileType", value = "文件类型(VIDEO, MUSIC, PICTURE)", required = true, dataType = "FileTypes")
    })
    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResultInfo upload(@RequestParam("file") MultipartFile file, @RequestParam("fileType") String fileType,
                      RedirectAttributes redirectAttributes) {

        FileTypes type = FileTypes.valueOf(fileType);
        if (type == null) {
            throw new StorageException("Failed to store file : no expected file type in {VIDEO,MUSIC,PICTURE}");
        }
        String fileId = UUID.randomUUID().toString().replaceAll("-", "");
        String fullPath = FileUploadUtil.store(file, type, fileId);
        if (fullPath != null) {
            FileBaseManager mediaInfo = getFileInfo(file, type, fullPath);
            mediaInfo.setUuid(fileId);
            mediaInfo.setPhysicalPath(fullPath);
            fileService.insert(mediaInfo);

        }
        return new ResultInfo();
    }

    @ApiOperation(value = "删除素材", notes = "删除素材")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileId", value = "素材ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "fileType", value = "文件类型(VIDEO, MUSIC, PICTURE)", required = true, dataType = "FileTypes")
    })
    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public @ResponseBody
        ResultInfo delete(@RequestParam("fileId") String fileId, @RequestParam("fileType") String fileType,
                      RedirectAttributes redirectAttributes) {
        FileTypes type = FileTypes.valueOf(fileType);
        if (type == null) {
            throw new StorageException("Failed to store file : no expected file type in {VIDEO,MUSIC,PICTURE}");
        }
        Map<String, String> param = new HashMap<>();
        param.put("uuid", fileId);
        if (fileService.deleteByMap(param)) {
            FileUploadUtil.deleteFile(type, fileId);
        }
        return new ResultInfo();
    }

    @ApiOperation(value = "查询素材", notes = "查询素材")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileName", value = "文件名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "fileType", value = "文件类型(VIDEO, MUSIC, PICTURE)", required = true, dataType = "FileTypes")
    })
    @RequestMapping(path = "/query", method = RequestMethod.POST)
    public @ResponseBody
    ResultInfo getData(@RequestParam("fileName") String fileName, @RequestParam("fileType") String fileType, @RequestParam("page") int page,@RequestParam("pageSize") int pageSize,
                      RedirectAttributes redirectAttributes) {
        FileTypes type = FileTypes.valueOf(fileType);
        if (type == null) {
            throw new StorageException("Failed to store file : no expected file type in {VIDEO,MUSIC,PICTURE}");
        }
        Wrapper<FileBaseManager> wrapper = new EntityWrapper<>();
        wrapper.like("name",fileName);
        Page<FileBaseManager> pageEnety =  new Page(page,pageSize);
        Page<FileBaseManager> data = fileService.selectPage(pageEnety,wrapper);
        ResultInfo result = new ResultInfo();
        result.setData(data.getRecords());
        return result;
    }

    private FileBaseManager getFileInfo(MultipartFile file, FileTypes type, String fileFullPath) {
        FileBaseManager fileInfo = null;
        if (type.equals(FileTypes.PICTURE)) {
            type = FileTypes.PICTURE;
        } else if (type.equals(FileTypes.MUSIC)) {
            type = FileTypes.MUSIC;
        } else {
            type = FileTypes.VIDEO;
            VideoManage vedio = new VideoManage();
            vedio.setTimeLength(MultimediaUtil.getVideoTime(fileFullPath, StorageProperties.FFMPEG_PATH));
            fileInfo = vedio;
        }
        fileInfo.setName(file.getOriginalFilename());
        return fileInfo;
    }

}
