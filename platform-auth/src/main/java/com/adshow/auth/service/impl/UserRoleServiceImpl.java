package com.adshow.auth.service.impl;

import com.adshow.auth.CommonConstant;
import com.adshow.auth.entity.Role;
import com.adshow.auth.entity.User;
import com.adshow.auth.entity.UserRole;
import com.adshow.auth.mapper.RoleMapper;
import com.adshow.auth.mapper.UserRoleMapper;
import com.adshow.auth.service.IUserRoleService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Autowired
    private RoleMapper roleMapper;

    public UserRoleMapper getBaseMapper() {
        return super.baseMapper;
    }

    @Override
    public List<UserRole> findByRoleId(String roleId) {
        Wrapper<UserRole> userRolesCondition = new EntityWrapper<UserRole>();
        userRolesCondition.eq("roleId", roleId);
        return getBaseMapper().selectList(userRolesCondition);
    }


    @Override
    public List<Role> findRolesByRoleId(String roleId) {
        Wrapper<UserRole> userRolesCondition = new EntityWrapper<UserRole>();
        userRolesCondition.eq("roleId", roleId);
        List<UserRole> list = getBaseMapper().selectList(userRolesCondition);
        List<String> idList = list.stream()
                .map(UserRole::getId).distinct()
                .collect(Collectors.toList());
        return roleMapper.selectBatchIds(idList);
    }


    @Override
    public boolean deleteByUserId(String userId) {
        Wrapper<UserRole> userRolesCondition = new EntityWrapper<UserRole>();
        userRolesCondition.eq("userId", userId);
        List<UserRole> list = getBaseMapper().selectList(userRolesCondition);
        List<String> idList = list.stream()
                .map(UserRole::getId).distinct()
                .collect(Collectors.toList());
        getBaseMapper().deleteBatchIds(idList);
        return true;
    }


}
