package com.adshow.material.service.impl;

import com.adshow.ad.entity.Video;
import com.adshow.ad.mapper.VideoMapper;
import com.adshow.common.MultimediaUtil;
import com.adshow.material.service.IVideoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-08-03
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {

    @Override
    @Async
    public void processThumbnails(String video_path, String ffmpeg_path) {
        MultimediaUtil.processThumbnail(video_path,ffmpeg_path);
    }
}
