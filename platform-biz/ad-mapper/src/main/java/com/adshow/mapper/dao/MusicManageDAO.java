package com.adshow.mapper.dao;

import com.adshow.mapper.entity.MusicManage;
import com.adshow.mapper.entity.MusicManageExample;
import org.springframework.stereotype.Repository;

/**
 * MusicManageDAO继承基类
 */
@Repository
public interface MusicManageDAO extends MyBatisBaseDao<MusicManage, Integer, MusicManageExample> {
}