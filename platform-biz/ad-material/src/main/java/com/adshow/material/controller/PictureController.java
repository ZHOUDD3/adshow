package com.adshow.material.controller;


import com.adshow.ad.entity.Picture;
import com.adshow.ad.entity.Video;
import com.adshow.common.FileTypes;
import com.adshow.common.FileUploadUtil;
import com.adshow.core.common.controller.BaseController;
import com.adshow.core.common.result.PageResult;
import com.adshow.core.common.result.Result;
import com.adshow.core.common.result.builder.ResponseEntityBuilder;
import com.adshow.core.common.utils.SnowFlakeUtil;
import com.adshow.exception.StorageException;
import com.adshow.material.service.IPictureService;
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
@RequestMapping("/ad/picture")
public class PictureController extends BaseController<Picture, IPictureService> {

    @Autowired
    private IPictureService pictureService;

    @Override
    protected IPictureService getBaseService() {
        return pictureService;
    }


    @ApiOperation(value = "上传", notes = "上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> upload(@RequestParam("file") MultipartFile file) {
        Picture picture = new Picture();
        picture.setId(String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId()));
        String fullPath = FileUploadUtil.store(file, FileTypes.PICTURE, picture.getId());
        if (fullPath != null) {
            picture.setPhysicalPath(fullPath);
            picture.setName(file.getOriginalFilename());
            getBaseService().insertOrUpdate(picture);
            return ResponseEntityBuilder.build(true, picture);
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
                    flag = FileUploadUtil.deleteFile(FileTypes.PICTURE, id);
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
        Wrapper<Picture> wrapper = new EntityWrapper<>();
        wrapper.like("name",name);
        return ResponseEntityBuilder
                .build(getBaseService().selectPage(new Page<Picture>(current, size),wrapper));
    }

}

