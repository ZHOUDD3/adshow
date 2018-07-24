package com.adshow.module.dao;

import com.adshow.module.entity.VideoManage;
import com.adshow.module.entity.VideoManageExample;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

/**
 * VideoManageDAO继承基类
 */
@Repository
public interface VideoManageDAO extends BaseMapper<VideoManage> {

}