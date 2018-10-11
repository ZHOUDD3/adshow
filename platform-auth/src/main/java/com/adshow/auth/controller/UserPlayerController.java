package com.adshow.auth.controller;


import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.adshow.core.common.controller.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wmz
 * @since 2018-10-09
 */
@RestController
@RequestMapping("/auth/userPlayer")
public class UserPlayerController extends BaseController {

    @Override
    protected IService getBaseService() {
        return null;
    }
}

