package com.adshow.ad.controller;


import com.adshow.ad.entity.ProgramMaterial;
import com.adshow.ad.service.IProgramMaterialService;
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
@RequestMapping("/ad/programMaterial")
public class ProgramMaterialController extends BaseController<ProgramMaterial, IProgramMaterialService> {

    @Autowired
    private IProgramMaterialService programMaterialService;

    @Override
    protected IProgramMaterialService getBaseService() {
        return programMaterialService;
    }
}

