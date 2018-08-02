package com.adshow.auth.controller;


import com.adshow.auth.entity.RolePermission;
import com.adshow.auth.service.IRolePermissionService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.adshow.core.common.controller.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@Slf4j
@RestController
@RequestMapping("/auth/rolePermission")
public class RolePermissionController extends BaseController <RolePermission, IRolePermissionService>{

    @Autowired
    private IRolePermissionService deptService;

    @Override
    protected IRolePermissionService getBaseService() {
        return deptService;
    }

}

