package com.adshow.ad.controller;


import com.adshow.ad.entity.ProgramMaterial;
import com.adshow.ad.entity.Subtitle;
import com.adshow.ad.service.IProgramMaterialService;
import com.adshow.ad.service.ISubtitleService;
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
 * @since 2018-08-03
 */
@RestController
@RequestMapping("/ad/subtitle")
public class SubtitleController extends BaseController<Subtitle, ISubtitleService> {

    @Autowired
    private ISubtitleService subtitleService;

    @Override
    protected ISubtitleService getBaseService() {
        return subtitleService;
    }
}

