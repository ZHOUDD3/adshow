package com.adshow.web.dao;

import com.adshow.web.entity.SubtitleManage;
import com.adshow.web.entity.SubtitleManageExample;
import org.springframework.stereotype.Repository;

/**
 * SubtitleManageDAO继承基类
 */
@Repository
public interface SubtitleManageDAO extends MyBatisBaseDao<SubtitleManage, Integer, SubtitleManageExample> {
}