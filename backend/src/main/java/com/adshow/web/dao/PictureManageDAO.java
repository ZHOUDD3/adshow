package com.adshow.web.dao;

import com.adshow.web.entity.PictureManage;
import com.adshow.web.entity.PictureManageExample;
import org.springframework.stereotype.Repository;

/**
 * PictureManageDAO继承基类
 */
@Repository
public interface PictureManageDAO extends MyBatisBaseDao<PictureManage, Integer, PictureManageExample> {
}