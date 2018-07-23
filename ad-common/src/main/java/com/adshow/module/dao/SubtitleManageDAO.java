package com.adshow.module.dao;

import com.adshow.module.entity.SubtitleManage;
import com.adshow.module.entity.SubtitleManageExample;
import org.springframework.stereotype.Repository;

/**
 * SubtitleManageDAO继承基类
 */
@Repository
public interface SubtitleManageDAO extends MyBatisBaseDao<SubtitleManage, Integer, SubtitleManageExample> {
}