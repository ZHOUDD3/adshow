package com.adshow.palyer.controller;


import com.adshow.ad.entity.PlayerStatus;
import com.adshow.palyer.service.IPlayerService;
import com.adshow.palyer.service.IPlayerStatusService;
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
@RequestMapping("/palyer/playerStatus")
public class PlayerStatusController extends BaseController<PlayerStatus,IPlayerStatusService> {

    @Override
    protected IPlayerStatusService getBaseService() {
        return null;
    }
}

