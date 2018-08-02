package com.adshow.auth.service;

import com.adshow.auth.entity.User;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
public interface IUserService extends IService<User> {


    /**
     * 通过用户名获取用户及其相关权限
     * @param username
     * @return
     */
    User getUserWithPermission(String username);

    User getUserByName(String username);

}
