package com.adshow.palyer.controller;


import com.adshow.ad.entity.PlayerProgram;
import com.adshow.palyer.service.IPlayerProgramService;
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
 * @since 2018-08-13
 */
@RestController
@RequestMapping("/palyer/playerProgram")
public class PlayerProgramController extends BaseController<PlayerProgram,IPlayerProgramService> {

    @Override
    protected IPlayerProgramService getBaseService() {
        return null;
    }
}

