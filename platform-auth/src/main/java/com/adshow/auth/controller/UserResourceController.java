package com.adshow.auth.controller;


import com.adshow.auth.entity.UserResource;
import com.adshow.auth.service.IUserResourceService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.adshow.core.common.controller.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wmz
 * @since 2018-08-13
 */
@RestController
@RequestMapping("/auth/userResource")
public class UserResourceController extends BaseController<UserResource,IUserResourceService> {

    @Override
    protected IUserResourceService getBaseService() {
        return null;
    }
}

