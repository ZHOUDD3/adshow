package com.adshow.auth.service.impl;

import com.adshow.auth.entity.Permission;
import com.adshow.auth.entity.RolePermission;
import com.adshow.auth.entity.UserRole;
import com.adshow.auth.mapper.PermissionMapper;
import com.adshow.auth.mapper.RolePermissionMapper;
import com.adshow.auth.service.IPermissionService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    public PermissionMapper getBaseMapper() {
        return super.baseMapper;
    }

    @Override
    public List<Permission> findByUserId(String userId) {
        return getBaseMapper().findByUserId(userId);
    }

    @Override
    public List<Permission> findByRoleId(String roleId) {
        return getBaseMapper().findByRoleId(roleId);
    }

    @Override
    public List<Permission> findByParentId(String parentId) {
        Wrapper<Permission> permissionCondition = new EntityWrapper<Permission>();
        permissionCondition.eq("parentId", parentId);
        List<String> ascColumns = new ArrayList<>();
        ascColumns.add("sortOrder");
        permissionCondition.orderAsc(ascColumns);
        return getBaseMapper().selectList(permissionCondition);
    }

    @Override
    public List<Permission> getAll() {
        return getBaseMapper().selectList(new EntityWrapper<Permission>());
    }

}
