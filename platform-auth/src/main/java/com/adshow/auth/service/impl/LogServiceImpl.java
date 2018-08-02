package com.adshow.auth.service.impl;

import com.adshow.auth.entity.Log;
import com.adshow.auth.mapper.LogMapper;
import com.adshow.auth.service.ILogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

    public LogMapper getBaseMapper() {
        return super.baseMapper;
    }

    @Override
    public boolean delAll() {
        return getBaseMapper().delAll();
    }
}
