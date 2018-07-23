package com.adshow.module.dao;

import com.adshow.module.entity.PictureManage;
import com.adshow.module.entity.PictureManageExample;
import org.springframework.stereotype.Repository;

/**
 * PictureManageDAO继承基类
 */
@Repository
public interface PictureManageDAO extends MyBatisBaseDao<PictureManage, Integer, PictureManageExample> {
}