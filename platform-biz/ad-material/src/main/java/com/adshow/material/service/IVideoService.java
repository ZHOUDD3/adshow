package com.adshow.material.service;

import com.adshow.ad.entity.Video;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.scheduling.annotation.Async;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-08-03
 */
public interface IVideoService extends IService<Video> {

    @Async
    public void processThumbnails(String video_path, String ffmpeg_path);

}
