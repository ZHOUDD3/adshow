package com.adshow.auth.controller;


import com.adshow.auth.CommonConstant;
import com.adshow.auth.entity.Permission;
import com.adshow.auth.entity.RolePermission;
import com.adshow.auth.service.IPermissionService;
import com.adshow.auth.service.IRolePermissionService;
import com.adshow.core.common.result.Result;
import com.adshow.core.common.result.builder.ResponseEntityBuilder;
import com.adshow.security.permission.SecurityMetadataSource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.adshow.core.common.controller.BaseController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@RestController
@RequestMapping("/auth/permission")
@Api(tags = "权限管理")
public class PermissionController extends BaseController<Permission, IPermissionService>  {

    @Override
    protected IPermissionService getBaseService() {
        return permissionService;
    }

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private IRolePermissionService rolePermissionService;

    @Autowired
    private SecurityMetadataSource securityMetadataSource;

    @RequestMapping(value = "/getMenuList/{userId}",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户页面菜单数据")
    public ResponseEntity<Result> getAllMenuList(@PathVariable String userId){

        //用户所有权限 已排序去重
        List<Permission> list = getBaseService().findByUserId(userId);

        List<Permission> menuList = new ArrayList<>();
        //筛选一级页面
        for(Permission p : list){
            if(CommonConstant.PERMISSION_PAGE.equals(p.getType())&&CommonConstant.LEVEL_ONE.equals(p.getLevel())){
                menuList.add(p);
            }
        }
        //筛选二级页面
        List<Permission> secondMenuList = new ArrayList<>();
        for(Permission p : list){
            if(CommonConstant.PERMISSION_PAGE.equals(p.getType())&&CommonConstant.LEVEL_TWO.equals(p.getLevel())){
                secondMenuList.add(p);
            }
        }
        //筛选二级页面拥有的按钮权限
        List<Permission> buttonPermissions = new ArrayList<>();
        for(Permission p : list){
            if(CommonConstant.PERMISSION_OPERATION.equals(p.getType())&&CommonConstant.LEVEL_THREE.equals(p.getLevel())){
                buttonPermissions.add(p);
            }
        }

        //匹配二级页面拥有权限
        for(Permission p : secondMenuList){
            List<String> permTypes = new ArrayList<>();
            for(Permission pe : buttonPermissions){
                if(p.getId().equals(pe.getParentId())){
                    permTypes.add(pe.getButtonType());
                }
            }
            p.setPermTypes(permTypes);
        }
        //匹配一级页面拥有二级页面
        for(Permission p : menuList){
            List<Permission> secondMenu = new ArrayList<>();
            for(Permission pe : secondMenuList){
                if(p.getId().equals(pe.getParentId())){
                    secondMenu.add(pe);
                }
            }
            p.setChildren(secondMenu);
        }

        return ResponseEntityBuilder.build(true, menuList);
    }

    @RequestMapping(value = "/getAllList",method = RequestMethod.GET)
    @ApiOperation(value = "获取权限菜单树")
    public ResponseEntity<Result> getAllList(){

        //一级
        List<Permission> list = getBaseService().findByParentId("1");
        //二级
        for(Permission p1 : list){
            List<Permission> children1 = getBaseService().findByParentId(p1.getId());
            p1.setChildren(children1);
            //三级
            for(Permission p2 : children1){
                List<Permission> children2 = getBaseService().findByParentId(p2.getId());
                p2.setChildren(children2);
            }
        }
        return ResponseEntityBuilder.build(true, list);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result> add(@ModelAttribute Permission permission){

        permissionService.insertOrUpdate(permission);
        //重新加载权限
        securityMetadataSource.loadResourceDefine();
        return ResponseEntityBuilder.build(true,permission);
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ApiOperation(value = "编辑")
    public ResponseEntity<Result> edit(@ModelAttribute Permission permission){

        getBaseService().insertOrUpdate(permission);
        //重新加载权限
        securityMetadataSource.loadResourceDefine();
        return ResponseEntityBuilder.build(true,permission);
    }

    @RequestMapping(value = "/delByIds",method = RequestMethod.DELETE)
    @ApiOperation(value = "批量通过id删除")
    public ResponseEntity<Result> delByIds(@RequestParam String[] ids){

        for(String id:ids){
            List<RolePermission> list = rolePermissionService.findByPermissionId(id);
            if(list!=null&&list.size()>0){
                return ResponseEntityBuilder.build(false,"删除失败，包含正被使用中的菜单或权限");
            }
        }
        for(String id:ids){
            getBaseService().deleteById(id);
        }
        //重新加载权限
        securityMetadataSource.loadResourceDefine();
        return ResponseEntityBuilder.build(false,"批量通过id删除数据成功");
    }

}

