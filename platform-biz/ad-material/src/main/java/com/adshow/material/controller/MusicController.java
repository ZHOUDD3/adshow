package com.adshow.material.controller;


import com.adshow.ad.entity.Music;
import com.adshow.common.FileTypes;
import com.adshow.common.FileUploadUtil;
import com.adshow.common.MultimediaUtil;
import com.adshow.common.StorageProperties;
import com.adshow.core.common.controller.BaseController;
import com.adshow.core.common.result.Result;
import com.adshow.core.common.result.builder.ResponseEntityBuilder;
import com.adshow.exception.StorageException;
import com.adshow.material.service.IMusicService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


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
    public ResponseEntity<Result> upload(@RequestParam("file") MultipartFile file, @RequestParam("fileType") String fileType) {

        FileTypes type = FileTypes.valueOf(fileType);
        if (type == null || !StringUtils.equals(FileTypes.MUSIC.name(), fileType)) {
            throw new StorageException("Failed to store file : no expected file type in {MUSIC}");
        }
        Music music = new Music();
        String fullPath = FileUploadUtil.store(file, type, music.getId());
        if (fullPath != null) {
            music.setPhysicalPath(fullPath);
            music.setTimeLength(MultimediaUtil.getVideoTime(fullPath, StorageProperties.FFMPEG_PATH).intValue());
            music.setName(file.getOriginalFilename());
            getBaseService().insertOrUpdate(music);
            return ResponseEntityBuilder.build(true, music);
        }
        return ResponseEntityBuilder.build(false, "上传失败");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除", notes = "根据 ID 删除")
    public ResponseEntity<Result> remove(@PathVariable String id) {
        boolean flag = getBaseService().deleteById(id);
        if (flag) {
            flag = FileUploadUtil.deleteFile(FileTypes.MUSIC, id);
        }
        return ResponseEntityBuilder.build(flag);
    }

}