package com.adshow.auth.controller;


import com.adshow.auth.entity.Dept;
import com.adshow.auth.service.IDeptService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.adshow.core.common.controller.BaseController;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@RestController
@RequestMapping("/auth/dept")
@Api(tags = "部门机构管理")
public class DeptController extends BaseController <Dept, IDeptService> {

    @Autowired
    private IDeptService deptService;

    @Override
    protected IDeptService getBaseService() {
        return deptService;
    }


}

