package com.adshow.web.module.videomanager.service;

import com.adshow.web.module.systemmanager.entity.User;
import com.adshow.web.module.videomanager.entity.VideoManage;

public interface IVideoService {

    /**
     * 保存视频信息
     */
    int saveVideo(VideoManage videoManage);
}
