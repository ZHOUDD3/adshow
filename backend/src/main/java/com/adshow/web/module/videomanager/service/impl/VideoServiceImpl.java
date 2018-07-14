package com.adshow.web.module.videomanager.service.impl;

import com.adshow.web.module.systemmanager.dao.VideoManageDAO;
import com.adshow.web.module.videomanager.entity.VideoManage;
import com.adshow.web.module.videomanager.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements IVideoService {

    @Autowired
    private VideoManageDAO videoManageDAO;
    @Override
    public int saveVideo(VideoManage videoManage) {
       return  videoManageDAO.insert(videoManage);
    }
}
