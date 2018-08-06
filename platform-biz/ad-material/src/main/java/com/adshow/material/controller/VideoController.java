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
import springfox.documentation.PathProvider;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<Result> upload(@RequestParam("file") MultipartFile file) {

        Video video = new Video();
        String fullPath = FileUploadUtil.store(file, FileTypes.VIDEO, video.getId());
        if (fullPath != null) {
            video.setPhysicalPath(fullPath);
            video.setTimeLength(MultimediaUtil.getVideoTime(fullPath, StorageProperties.FFMPEG_PATH).intValue());
            video.setName(file.getOriginalFilename());
            getBaseService().insertOrUpdate(video);
            return ResponseEntityBuilder.build(true, video);
        }
        return ResponseEntityBuilder.build(false, "上传失败");
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
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

    @RequestMapping(value = "view/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询", notes = "分页查询，支持基本条件筛选")
    public @ResponseBody void  view(
            @PathVariable String id,
            @ApiIgnore HttpServletResponse response) {
        Path secondPath = Paths.get(StorageProperties.FILE_ROOT_PATH,FileTypes.VIDEO.toString(),id);
        Path vPath = null;
        try {
            final List<Path> pathsToView = Files.walk(secondPath).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            if(pathsToView !=null && pathsToView.size()>0){
                vPath = pathsToView.get(0);
            }else{
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = vPath.toFile();
        try (FileInputStream in = new FileInputStream(file);ServletOutputStream out= response.getOutputStream()){
            byte[] b = null;
            while(in.available() >0) {
                if(in.available()>10240) {
                    b = new byte[10240];
                }else {
                    b = new byte[in.available()];
                }
                in.read(b, 0, b.length);
                out.write(b, 0, b.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

