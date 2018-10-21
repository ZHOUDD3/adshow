package com.adshow.auth.controller;


import com.adshow.auth.entity.Dept;
import com.adshow.auth.service.IDeptService;
import com.adshow.core.common.controller.BaseController;
import com.adshow.core.common.result.Result;
import com.adshow.core.common.result.builder.ResponseEntityBuilder;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@RestController
@RequestMapping("/auth/dept")
@Api(tags = "部门机构管理")
public class DeptController extends BaseController<Dept, IDeptService> {

    @Autowired
    private IDeptService deptService;

    @Override
    protected IDeptService getBaseService() {
        return deptService;
    }


    @RequestMapping(value = "/listByParent/{parentId}", method = RequestMethod.GET)
    @ApiOperation(value = "通过id获取")
    public ResponseEntity<Result> getByParentId(@PathVariable String parentId) {
        Dept dept = new Dept();
        dept.setParentId(parentId);
        EntityWrapper deptCondition = new EntityWrapper<Dept>(dept);
        deptCondition.orderAsc(Collections.singleton("sort_order"));
        return ResponseEntityBuilder.build(true, getBaseService().selectList(deptCondition));
    }

//    @RequestMapping(value = "/add",method = RequestMethod.POST)
//    @ApiOperation(value = "添加")
//    @CacheEvict(key = "#department.parentId")
//    public Result<Dept> add(@ModelAttribute Dept dept){
//
//        Department d = departmentService.save(department);
//        // 如果不是添加的一级 判断设置上级为父节点标识
//        if(!CommonConstant.PARENT_ID.equals(department.getParentId())){
//            Department parent = departmentService.get(department.getParentId());
//            if(parent.getIsParent()==null||!parent.getIsParent()){
//                parent.setIsParent(true);
//                departmentService.update(parent);
//                // 更新上级节点的缓存
//                redisTemplate.delete("department::" + parent.getParentId());
//            }
//        }
//        return new ResultUtil<Department>().setData(d);
//    }
//
//    @RequestMapping(value = "/edit",method = RequestMethod.POST)
//    @ApiOperation(value = "编辑")
//    public Result<Department> edit(@ModelAttribute Department department){
//
//        Department d = departmentService.update(department);
//        // 手动删除所有部门缓存
//        Set<String> keys = redisTemplate.keys("department:" + "*");
//        redisTemplate.delete(keys);
//        // 删除所有用户缓存
//        Set<String> keysUser = redisTemplate.keys("user:" + "*");
//        redisTemplate.delete(keysUser);
//        return new ResultUtil<Department>().setData(d);
//    }
//
//    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
//    @ApiOperation(value = "批量通过id删除")
//    public Result<Object> delByIds(@PathVariable String[] ids){
//
//        for(String id:ids){
//            List<User> list = userService.findByDepartmentId(id);
//            if(list!=null&&list.size()>0){
//                return new ResultUtil<Object>().setErrorMsg("删除失败，包含正被用户使用关联的部门");
//            }
//        }
//        for(String id:ids){
//            departmentService.delete(id);
//        }
//        // 手动删除所有部门缓存
//        Set<String> keys = redisTemplate.keys("department:" + "*");
//        redisTemplate.delete(keys);
//        return new ResultUtil<Object>().setSuccessMsg("批量通过id删除数据成功");
//    }

}

