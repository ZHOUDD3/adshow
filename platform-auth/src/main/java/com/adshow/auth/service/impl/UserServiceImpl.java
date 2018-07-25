package com.adshow.auth.service.impl;

import com.adshow.auth.mapper.dao.UserDao;
import com.adshow.auth.mapper.entity.User;
import com.adshow.auth.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户管理 service
 */
@Primary
@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserDao userDao;

    @Override
    public int setStatus(Integer userId, int status) {
        return userDao.setStatus(userId,status);

    }

    @Override
    public int changePwd(Integer userId, String pwd) {
        return userDao.changePwd(userId,pwd);
    }

    @Override
    public List<Map<String, Object>> selectUsers( String name, String beginTime, String endTime, Integer deptid) {
        return  userDao.selectUsers(name,beginTime,endTime,deptid);
    }

    @Override
    public int setRoles(Integer userId, String roleIds) {
        return userDao.setRoles(userId,roleIds);
    }

    @Override
    public User getByAccount(String account) {
        return userDao.getByAccount(account);
    }

    @Override
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }
}
