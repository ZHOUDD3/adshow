package com.adshow.palyer.controller;


import com.adshow.palyer.entity.Player;
import com.adshow.palyer.service.IPlayerService;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.adshow.core.common.controller.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wmz
 * @since 2018-08-11
 */
@RestController
@RequestMapping("/palyer/player")
public class PlayerController extends BaseController<Player,IPlayerService> {


    @Autowired
    private  IPlayerService playerService;
    @Override
    protected IPlayerService getBaseService() {
        return playerService;
    }
}

