package com.adshow.web.module.systemmanager.dao;

import com.adshow.web.module.videomanager.entity.VideoManage;
import com.adshow.web.module.videomanager.entity.VideoManageExample;
import org.springframework.stereotype.Repository;

/**
 * VideoManageDAO继承基类
 */
@Repository
public interface VideoManageDAO extends MyBatisBaseDao<VideoManage, String, VideoManageExample> {
}