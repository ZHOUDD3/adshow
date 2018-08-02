package com.adshow.auth.service.impl;

import com.adshow.auth.entity.Role;
import com.adshow.auth.mapper.RoleMapper;
import com.adshow.auth.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public List<Role> findByDefaultRole(Boolean defaultRole) {
        return null;
    }
}
