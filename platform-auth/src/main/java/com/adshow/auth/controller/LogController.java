package com.adshow.auth.controller;


import com.adshow.auth.entity.Log;
import com.adshow.auth.service.ILogService;
import com.adshow.core.common.result.PageResult;
import com.adshow.core.common.result.Result;
import com.adshow.core.common.result.builder.ResponseEntityBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.adshow.core.common.controller.BaseController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@Api(tags = "日志管理")
@RestController
@RequestMapping("/auth/log")
public class LogController extends BaseController <Log, ILogService> {

    protected ILogService getBaseService(){
        return logService;
    }

    @Autowired
    private ILogService logService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询日志", notes = "分页查询，支持基本条件筛选")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码", required = false, defaultValue = "1", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页数据量", required = false, defaultValue = "10", dataType = "int", paramType = "query"),
    })
    @Override
    public ResponseEntity<PageResult> page(
            @RequestParam(defaultValue = "1", required = false) int current,
            @RequestParam(defaultValue = "10", required = false) int size,
            Log logVo,
            @ApiIgnore HttpServletRequest request,
            @ApiIgnore HttpServletResponse response){
        return super.page(current, size, logVo, request, response);
    }

    @RequestMapping(value = "/delByIds",method = RequestMethod.DELETE)
    @ApiOperation(value = "批量删除")
    public ResponseEntity<Result> delByIds(@RequestParam String[] ids){

        for(String id : ids){
            logService.deleteById(id);
        }
        return ResponseEntityBuilder.build(true, "删除成功");
    }

    @RequestMapping(value = "/delAll",method = RequestMethod.DELETE)
    @ApiOperation(value = "全部删除")
    public ResponseEntity<Result> delAll(){


        logService.delAll();
        return ResponseEntityBuilder.build(true, "删除成功");
    }
}

