package com.adshow.auth.service;

import com.adshow.auth.entity.Log;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
public interface ILogService extends IService<Log> {

    boolean delAll();

}
