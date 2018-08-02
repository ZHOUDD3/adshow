package com.adshow.auth.controller;


import com.adshow.auth.entity.Permission;
import com.adshow.auth.entity.Role;
import com.adshow.auth.entity.RolePermission;
import com.adshow.auth.entity.UserRole;
import com.adshow.auth.service.IPermissionService;
import com.adshow.auth.service.IRolePermissionService;
import com.adshow.auth.service.IRoleService;
import com.adshow.auth.service.IUserRoleService;
import com.adshow.core.common.result.PageResult;
import com.adshow.core.common.result.Result;
import com.adshow.core.common.result.builder.ResponseEntityBuilder;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.adshow.core.common.controller.BaseController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@Slf4j
@RestController
@RequestMapping("/auth/role")
@Api(tags = "角色管理")
public class RoleController extends BaseController<Role, IRoleService> {

    @Override
    protected IRoleService getBaseService() {
        return roleService;
    }

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IRolePermissionService rolePermissionService;

    @Autowired
    private IPermissionService permissionService;

    @ApiOperation(value = "获取全部角色", notes = "查询全部，支持基本条件筛选")
    public ResponseEntity<Result> all(Role role) {
        return super.all(role);
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "分页获取角色, 包含角色下挂的权限", notes = "分页查询，支持基本条件筛选")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码", required = false, defaultValue = "1", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页数据量", required = false, defaultValue = "10", dataType = "int", paramType = "query"),
    })
    @Override
    public ResponseEntity<PageResult> page(
            @RequestParam(defaultValue = "1", required = false) int current,
            @RequestParam(defaultValue = "10", required = false) int size,
            Role roleCondition,
            @ApiIgnore HttpServletRequest request,
            @ApiIgnore HttpServletResponse response) {
        Page<Role> page = getBaseService().selectPage(new Page<Role>(current, size), new EntityWrapper<Role>(roleCondition));

        for (Role role : page.getRecords()) {
            List<Permission> permissions = permissionService.findByRoleId(role.getId());
            role.setPermissions(permissions);
        }
        return ResponseEntityBuilder.build(page);
    }

    @RequestMapping(value = "/setDefault", method = RequestMethod.POST)
    @ApiOperation(value = "设置或取消默认角色")
    public ResponseEntity<Result> setDefault(@RequestParam String id,
                                             @RequestParam Boolean isDefault) {

        Role role = roleService.selectById(id);
        if (role == null) {
            return ResponseEntityBuilder.build(false, "角色不存在");
        }
        role.setDefaultRole(isDefault);
        roleService.insertOrUpdate(role);
        return ResponseEntityBuilder.build(false, "设置成功");
    }

    @RequestMapping(value = "/editRolePerm/{roleId}", method = RequestMethod.POST)
    @ApiOperation(value = "编辑角色分配权限")
    public ResponseEntity<Result> editRolePerm(@PathVariable String roleId,
                                               @RequestParam(required = false) String[] permIds) {

        //删除其关联权限
        rolePermissionService.deleteByRoleId(roleId);
        //分配新权限
        for (String permId : permIds) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permId);
            rolePermissionService.insertOrUpdate(rolePermission);
        }
        return ResponseEntityBuilder.build(true, null);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation(value = "更新数据")
    public ResponseEntity<Result> edit(@ModelAttribute Role role) {

        boolean flag = roleService.insertOrUpdate(role);
        return ResponseEntityBuilder.build(true, role);
    }

    @RequestMapping(value = "/delAllByIds", method = RequestMethod.DELETE)
    @ApiOperation(value = "批量通过ids删除")
    public ResponseEntity<Result> delByIds(@RequestParam String[] ids) {

        for (String id : ids) {
            List<UserRole> list = userRoleService.findByRoleId(id);
            if (list != null && list.size() > 0) {
                return ResponseEntityBuilder.build(false, "删除失败，包含正被使用中的角色");
            }
        }
        for (String id : ids) {
            roleService.deleteById(id);
            //删除关联权限
            rolePermissionService.deleteByRoleId(id);
        }
        return ResponseEntityBuilder.build(true, "批量通过id删除数据成功");
    }
}

