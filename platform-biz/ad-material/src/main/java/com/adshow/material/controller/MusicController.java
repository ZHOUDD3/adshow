package com.adshow.material.controller;


import com.adshow.ad.entity.Music;
import com.adshow.ad.entity.Video;
import com.adshow.common.FileTypes;
import com.adshow.common.FileUploadUtil;
import com.adshow.common.MultimediaUtil;
import com.adshow.common.StorageProperties;
import com.adshow.core.common.controller.BaseController;
import com.adshow.core.common.result.PageResult;
import com.adshow.core.common.result.Result;
import com.adshow.core.common.result.builder.ResponseEntityBuilder;
import com.adshow.core.common.utils.SnowFlakeUtil;
import com.adshow.exception.StorageException;
import com.adshow.material.service.IMusicService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
@RequestMapping("/ad/music")
public class MusicController extends BaseController<Music, IMusicService> {

    @Autowired
    private IMusicService musicService;

    @Override
    protected IMusicService getBaseService() {
        return musicService;
    }

    @ApiOperation(value = "上传", notes = "上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> upload(@RequestParam("file") MultipartFile file ) {

        Music music = new Music();
        music.setId(String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId()));
        String fullPath = FileUploadUtil.store(file, FileTypes.MUSIC, music.getId());
        if (fullPath != null) {
            music.setPhysicalPath(fullPath);
            music.setName(file.getOriginalFilename());
            getBaseService().insertOrUpdate(music);
            return ResponseEntityBuilder.build(true, music);
        }
        return ResponseEntityBuilder.build(false, "上传失败");
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除", notes = "根据 ID 删除")
    public ResponseEntity<Result> remove(String[] ids) {

        if(ids!=null && ids.length>0){
            for (String id : ids ) {
                boolean flag = getBaseService().deleteById(id);
                if (flag) {
                    flag = FileUploadUtil.deleteFile(FileTypes.MUSIC, id);
                }
            }
        }
        return ResponseEntityBuilder.build(true);
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询", notes = "分页查询，支持基本条件筛选")
    public ResponseEntity<PageResult> list(
            @RequestParam(defaultValue = "1", required = false) int current,
            @RequestParam(defaultValue = "10", required = false) int size,
            String name,
            @ApiIgnore HttpServletRequest request,
            @ApiIgnore HttpServletResponse response) {
        Wrapper<Music> wrapper = new EntityWrapper<>();
        wrapper.like("name",name);
        return ResponseEntityBuilder
                .build(getBaseService().selectPage(new Page<Music>(current, size),wrapper));
    }


}