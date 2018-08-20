package com.adshow.auth.controller;


import com.adshow.auth.entity.ResourcePlayer;
import com.adshow.auth.service.IResourcePlayerService;
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
@RequestMapping("/auth/resourcePlayer")
public class ResourcePlayerController extends BaseController<ResourcePlayer,IResourcePlayerService> {

    @Override
    protected IResourcePlayerService getBaseService() {
        return null;
    }
}

