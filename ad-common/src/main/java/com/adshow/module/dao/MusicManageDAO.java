package com.adshow.module.dao;

import com.adshow.module.entity.MusicManage;
import com.adshow.module.entity.MusicManageExample;
import org.springframework.stereotype.Repository;

/**
 * MusicManageDAO继承基类
 */
@Repository
public interface MusicManageDAO extends MyBatisBaseDao<MusicManage, Integer, MusicManageExample> {
}