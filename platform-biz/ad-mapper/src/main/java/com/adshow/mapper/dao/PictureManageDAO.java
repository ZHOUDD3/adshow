package com.adshow.mapper.dao;

import com.adshow.mapper.entity.PictureManage;
import com.adshow.mapper.entity.PictureManageExample;
import org.springframework.stereotype.Repository;

/**
 * PictureManageDAO继承基类
 */
@Repository
public interface PictureManageDAO extends MyBatisBaseDao<PictureManage, Integer, PictureManageExample> {
}