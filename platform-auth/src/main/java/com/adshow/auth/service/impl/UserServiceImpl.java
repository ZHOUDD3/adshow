package com.adshow.auth.service.impl;

import com.adshow.auth.CommonConstant;
import com.adshow.auth.entity.Permission;
import com.adshow.auth.entity.Role;
import com.adshow.auth.entity.User;
import com.adshow.auth.entity.UserRole;
import com.adshow.auth.mapper.PermissionMapper;
import com.adshow.auth.mapper.UserMapper;
import com.adshow.auth.mapper.UserRoleMapper;
import com.adshow.auth.service.IUserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    public UserMapper getBaseMapper() {
        return super.baseMapper;
    }

    @Override
    public User getUserWithPermission(String username) {
        Wrapper<User> userCondition = new EntityWrapper<User>();
        userCondition.eq("username", "username");
        userCondition.eq("status", CommonConstant.USER_STATUS_NORMAL);
        List<User> list = getBaseMapper().selectList(userCondition);
        if (list != null && list.size() > 0) {
            User user = list.get(0);
            List<Role> roleList = userRoleMapper.findRolesByUserId(user.getId());
            user.setRoles(roleList);
            List<Permission> permissionList = permissionMapper.findByUserId(user.getId());
            user.setPermissions(permissionList);
            return user;
        }
        return null;
    }

    @Override
    public User getUserByName(String username) {
        Wrapper<User> userCondition = new EntityWrapper<User>();
        userCondition.eq("username", "username");
        List<User> result = getBaseMapper().selectList(userCondition);
        return result == null ? null : result.get(0);
    }
}
