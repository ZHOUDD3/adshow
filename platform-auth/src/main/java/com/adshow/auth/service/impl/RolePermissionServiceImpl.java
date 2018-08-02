package com.adshow.auth.service.impl;

import com.adshow.auth.entity.RolePermission;
import com.adshow.auth.mapper.RolePermissionMapper;
import com.adshow.auth.service.IRolePermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {


    public RolePermissionMapper getBaseMapper() {
        return super.baseMapper;
    }


    @Override
    public List<RolePermission> findByPermissionId(String permissionId) {

        return getBaseMapper().findByPermissionId(permissionId);
    }

    @Override
    public void deleteByRoleId(String roleId) {

        getBaseMapper().deleteByRoleId(roleId);
    }
}
