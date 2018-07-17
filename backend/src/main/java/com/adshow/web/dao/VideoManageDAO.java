package com.adshow.web.dao;

import com.adshow.web.entity.VideoManage;
import com.adshow.web.entity.VideoManageExample;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * VideoManageDAO继承基类
 */
@Repository
public interface VideoManageDAO extends BaseMapper<VideoManage> {

}