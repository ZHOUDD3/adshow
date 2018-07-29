package com.adshow.mapper.dao;

import com.adshow.mapper.entity.SubtitleManage;
import com.adshow.mapper.entity.SubtitleManageExample;
import org.springframework.stereotype.Repository;

/**
 * SubtitleManageDAO继承基类
 */
@Repository
public interface SubtitleManageDAO extends MyBatisBaseDao<SubtitleManage, Integer, SubtitleManageExample> {
}