package com.adshow.auth.mapper;

import com.adshow.auth.entity.Log;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
public interface LogMapper extends BaseMapper<Log> {

    boolean delAll();
}
