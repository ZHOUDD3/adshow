package com.adshow.ad.controller;


import com.adshow.ad.entity.Program;
import com.adshow.ad.entity.ProgramMaterial;
import com.adshow.ad.service.IProgramMaterialService;
import com.adshow.core.common.controller.BaseController;
import com.adshow.core.common.result.Result;
import com.adshow.core.common.result.builder.ResponseEntityBuilder;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping(value = "view/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询", notes = "分页查询，支持基本条件筛选")
    public ResponseEntity<Result> view(
            @PathVariable String id){

        Wrapper<ProgramMaterial> wrapper = new EntityWrapper<>();
        wrapper.eq("program_id",id);
        return ResponseEntityBuilder.build(true, getBaseService().selectList(wrapper));
    }
}

