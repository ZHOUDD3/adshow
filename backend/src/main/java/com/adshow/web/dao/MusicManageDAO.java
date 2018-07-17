package com.adshow.web.dao;

import com.adshow.web.entity.MusicManage;
import com.adshow.web.entity.MusicManageExample;
import org.springframework.stereotype.Repository;

/**
 * MusicManageDAO继承基类
 */
@Repository
public interface MusicManageDAO extends MyBatisBaseDao<MusicManage, Integer, MusicManageExample> {
}