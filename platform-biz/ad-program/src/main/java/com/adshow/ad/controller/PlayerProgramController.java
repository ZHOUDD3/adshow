package com.adshow.ad.controller;


import com.adshow.ad.entity.PlayerProgram;
import com.adshow.ad.service.IPlayerProgramService;
import com.adshow.core.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-08-03
 */
@RestController
@RequestMapping("/ad/playerProgram")
public class PlayerProgramController extends BaseController<PlayerProgram, IPlayerProgramService> {

    @Autowired
    private IPlayerProgramService playerProgramService;

    @Override
    protected IPlayerProgramService getBaseService() {
        return playerProgramService;
    }
}

