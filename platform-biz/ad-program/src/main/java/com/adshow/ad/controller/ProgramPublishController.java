package com.adshow.ad.controller;

import cn.hutool.core.util.StrUtil;
import com.adshow.ad.entity.ProgramPublish;
import com.adshow.core.common.controller.BaseController;
import com.adshow.core.common.result.PageResult;
import com.adshow.core.common.result.builder.ResponseEntityBuilder;
import com.adshow.palyer.service.IProgramPublishService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author martin
 * @Date 2018/10/11
 */
@RestController
@RequestMapping("/ad/programPublish")
public class ProgramPublishController extends BaseController {

    @Autowired
    private IProgramPublishService programPublishService;

    @Override
    protected IService getBaseService() {
        return  programPublishService;
    }

    protected IProgramPublishService getProgramPublishService() {
        return  programPublishService;
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询", notes = "分页查询，支持基本条件筛选")
    public ResponseEntity<PageResult> list(
            @RequestParam(defaultValue = "1", required = false) int current,
            @RequestParam(defaultValue = "10", required = false) int size,
            String name,
            String publishId,
            @ApiIgnore HttpServletRequest request,
            @ApiIgnore HttpServletResponse response) {
        Wrapper<ProgramPublish> wrapper = new EntityWrapper<>();
        if(!StrUtil.isBlank(name)){
            wrapper.like("program_name", name);
        }
        if(!StrUtil.isBlank(publishId)){
            wrapper.and().like("publish_id",publishId);
        }
        return ResponseEntityBuilder
                .build(getBaseService().selectPage(new Page<ProgramPublish>(current, size), wrapper));
    }


}
