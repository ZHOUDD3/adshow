package com.adshow.ad.controller;


import com.adshow.ad.entity.Program;
import com.adshow.ad.service.IProgramService;
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
@RequestMapping("/ad/program")
public class ProgramController extends BaseController<Program, IProgramService> {

    @Autowired
    private IProgramService programService;

    @Override
    protected IProgramService getBaseService() {
        return programService;
    }





}

