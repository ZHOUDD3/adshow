package com.adshow.material.controller;


import com.adshow.ad.entity.Video;
import com.adshow.common.FileTypes;
import com.adshow.common.FileUploadUtil;
import com.adshow.common.MultimediaUtil;
import com.adshow.common.StorageProperties;
import com.adshow.core.common.controller.BaseController;
import com.adshow.core.common.result.PageResult;
import com.adshow.core.common.result.Result;
import com.adshow.core.common.result.builder.ResponseEntityBuilder;
import com.adshow.exception.StorageException;
import com.adshow.material.service.IVideoService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-08-03
 */
@RestController
@RequestMapping("/ad/video")
public class VideoController extends BaseController<Video, IVideoService> {

    @Autowired
    private IVideoService videoService;

    @Override
    protected IVideoService getBaseService() {
        return videoService;
    }

    @ApiOperation(value = "上传", notes = "上传")

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> upload(@RequestParam("file") MultipartFile file, @RequestParam("fileType") String fileType) {

        FileTypes type = FileTypes.valueOf(fileType);
        if (type == null || !StringUtils.equals(FileTypes.VIDEO.name(), fileType)) {
            throw new StorageException("Failed to store file : no expected file type in {VIDEO}");
        }
        Video video = new Video();
        String fullPath = FileUploadUtil.store(file, type, video.getId());
        if (fullPath != null) {
            video.setPhysicalPath(fullPath);
            video.setTimeLength(MultimediaUtil.getVideoTime(fullPath, StorageProperties.FFMPEG_PATH).intValue());
            video.setName(file.getOriginalFilename());
            getBaseService().insertOrUpdate(video);
            return ResponseEntityBuilder.build(true, video);
        }
        return ResponseEntityBuilder.build(false, "上传失败");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除", notes = "根据 ID 删除")
    public ResponseEntity<Result> remove(@PathVariable String id) {
        boolean flag = getBaseService().deleteById(id);
        if (flag) {
            flag = FileUploadUtil.deleteFile(FileTypes.VIDEO, id);
        }
        return ResponseEntityBuilder.build(flag);
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询", notes = "分页查询，支持基本条件筛选")
    public ResponseEntity<PageResult> list(
            @RequestParam(defaultValue = "1", required = false) int current,
            @RequestParam(defaultValue = "10", required = false) int size,
            String name,
            @ApiIgnore HttpServletRequest request,
            @ApiIgnore HttpServletResponse response) {
        Wrapper<Video> wrapper = new EntityWrapper<>();
        wrapper.like("name",name);
        return ResponseEntityBuilder
                .build(getBaseService().selectPage(new Page<Video>(current, size),wrapper));
    }

}

