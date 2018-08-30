package com.adshow.auth.controller;


import com.adshow.auth.CommonConstant;
import com.adshow.auth.entity.Role;
import com.adshow.auth.entity.User;
import com.adshow.auth.entity.UserRole;
import com.adshow.auth.service.IRoleService;
import com.adshow.auth.service.IUserRoleService;
import com.adshow.auth.service.IUserService;
import com.adshow.core.common.controller.BaseController;
import com.adshow.core.common.result.PageResult;
import com.adshow.core.common.result.Result;
import com.adshow.core.common.result.builder.ResponseEntityBuilder;
import com.adshow.core.common.utils.ResponseUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.adshow.core.common.constant.StatusConstant.RELOGIN;
import static com.adshow.core.common.constant.StatusConstant.WRONG_PASSWORD;

/**
 * <p>
 * 用户前端控制器
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@Slf4j
@RestController
@RequestMapping("/auth/user")
@Api(tags = "用户管理")
public class UserController extends BaseController<User, IUserService> {

    @Override
    protected IUserService getBaseService() {
        return userService;
    }

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserRoleService userRoleService;

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ApiOperation(value = "注册用户")
    public ResponseEntity<Result> regist(@ModelAttribute User user) {

        if (userService.getUserByName(user.getUsername()) != null) {
            return ResponseEntityBuilder.build(false, "该用户名已被注册");
        }

        String encryptPass = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encryptPass);
        user.setType(CommonConstant.USER_TYPE_NORMAL);
        boolean flag = userService.insert(user);
        if (!flag) {
            return ResponseEntityBuilder.build(false, "注册失败");
        }
        // 默认角色
        List<Role> roleList = roleService.findByDefaultRole(true);
        if (roleList != null && roleList.size() > 0) {
            for (Role role : roleList) {
                UserRole ur = new UserRole();
                ur.setUserId(user.getId());
                ur.setRoleId(role.getId());
                userRoleService.insert(ur);
            }
        }
        return ResponseEntityBuilder.build(true, user);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ApiOperation(value = "获取当前登录用户接口")
    public ResponseEntity<Result> getUserInfo() {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUserByName(userDetails.getUsername());
        user.setPassword(null);
        return ResponseEntityBuilder.build(true, user);
    }

    @RequestMapping(value = "/unlock", method = RequestMethod.POST)
    @ApiOperation(value = "解锁验证密码")
    public ResponseEntity<Result> unLock(@RequestParam String password) {

        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User u = userService.getUserByName(user.getUsername());
        if (!new BCryptPasswordEncoder().matches(password, u.getPassword())) {
            return ResponseEntityBuilder.build(false, "密码不正确");
        }
        return ResponseEntityBuilder.build(true, null);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation(value = "修改用户自己资料", notes = "用户名密码不会修改 需要通过id获取原用户信息 需要username更新缓存")
    public ResponseEntity<Result> editOwn(@ModelAttribute User user) {

        User userExists = userService.selectById(user.getId());
        user.setUsername(userExists.getUsername());
        user.setPassword(userExists.getPassword());
        userService.insertOrUpdate(user);
        if (user == null) {
            return ResponseEntityBuilder.build(false, "修改失败");
        }
        return ResponseEntityBuilder.build(true, "修改成功");
    }

    /**
     * @param user
     * @param roles
     * @return
     */
    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    @ApiOperation(value = "修改资料", notes = "需要通过id获取原用户信息 需要username更新缓存")
    public ResponseEntity<Result> edit(@ModelAttribute User user,
                                       @RequestParam(required = false) String[] roles) {

        User userExist = userService.selectById(user.getId());
        //所修改了用户名
        if (!userExist.getUsername().equals(user.getUsername())) {
            //判断新用户名是否存在
            if (userService.getUserByName(user.getUsername()) != null) {
                return ResponseEntityBuilder.build(false, "该用户名已被存在");
            }
        }

        user.setPassword(userExist.getPassword());
        userService.insertOrUpdate(user);
        if (user == null) {
            return ResponseEntityBuilder.build(false, "修改失败");
        }
        //删除该用户角色
        userRoleService.deleteByUserId(user.getId());
        if (roles != null && roles.length > 0) {
            //新角色
            for (String roleId : roles) {
                UserRole userRole = new UserRole();
                userRole.setRoleId(roleId);
                userRole.setUserId(user.getId());
                userRoleService.insertOrUpdate(userRole);
            }
        }
        return ResponseEntityBuilder.build(false, "修改成功");
    }

    /**
     * 线上demo仅允许ADMIN权限改密码
     *
     * @param id
     * @param password
     * @param newPass
     * @return
     */
    @RequestMapping(value = "/modifyPass", method = RequestMethod.POST)
    @ApiOperation(value = "修改密码")
    public ResponseEntity<Result> modifyPass(@ApiParam("需用户id获取原用户数据") @RequestParam String id,
                                             @ApiParam("password") @RequestParam String password,
                                             @ApiParam("新密码") @RequestParam String newPass) {

        User userExist = userService.selectById(id);

        if (!new BCryptPasswordEncoder().matches(password, userExist.getPassword())) {
            return ResponseEntityBuilder.build(false, "旧密码不正确");
        }

        String newEncryptPass = new BCryptPasswordEncoder().encode(newPass);
        userExist.setPassword(newEncryptPass);
        userService.insertOrUpdate(userExist);
        if (userExist == null) {
            return ResponseEntityBuilder.build(false, "修改失败");
        }

        return ResponseEntityBuilder.build(false, userExist);
    }

    @ApiOperation(value = "多条件分页获取用户列表,返回的用户对象包含角色列表")
    public ResponseEntity<PageResult> page(
            @RequestParam(defaultValue = "1", required = false) int current,
            @RequestParam(defaultValue = "10", required = false) int size,
            User userCondition,
            @ApiIgnore HttpServletRequest request,
            @ApiIgnore HttpServletResponse response) {
        Page<User> page = getBaseService().selectPage(new Page<User>(current, size), new EntityWrapper<User>(userCondition));
        for (User user : page.getRecords()) {
            List<Role> list = userRoleService.findRolesByRoleId(user.getId());
            user.setRoles(list);
            user.setPassword(null);
        }
        return ResponseEntityBuilder.build(page);
    }


    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户")
    public ResponseEntity<Result> regist(@ModelAttribute User user,
                                         @RequestParam(required = false) String[] roles) {

        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return ResponseEntityBuilder.build(false, "缺少必需表单字段");
        }

        if (userService.getUserByName(user.getUsername()) != null) {
            return ResponseEntityBuilder.build(false, "该用户名已被注册");
        }

        String encryptPass = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encryptPass);
        boolean flag = userService.insertOrUpdate(user);
        if (!flag) {
            return ResponseEntityBuilder.build(false, "添加失败");
        }
        if (roles != null && roles.length > 0) {
            //添加角色
            for (String roleId : roles) {
                UserRole userRole = new UserRole();
                userRole.setUserId(user.getId());
                userRole.setRoleId(roleId);
                userRoleService.insertOrUpdate(userRole);
            }
        }

        return ResponseEntityBuilder.build(true, user);
    }

    @RequestMapping(value = "/admin/disable/{userId}", method = RequestMethod.POST)
    @ApiOperation(value = "后台禁用用户")
    public ResponseEntity<Result> disable(@ApiParam("用户唯一id标识") @PathVariable String userId) {

        User user = userService.selectById(userId);
        if (user == null) {
            return ResponseEntityBuilder.build(false, "通过userId获取用户失败");
        }
        user.setStatus(CommonConstant.USER_STATUS_LOCK);
        userService.insertOrUpdate(user);
        return ResponseEntityBuilder.build(true, null);
    }

    @RequestMapping(value = "/admin/enable/{userId}", method = RequestMethod.POST)
    @ApiOperation(value = "后台启用用户")
    public ResponseEntity<Result> enable(@ApiParam("用户唯一id标识") @PathVariable String userId) {

        User user = userService.selectById(userId);
        if (user == null) {
            return ResponseEntityBuilder.build(false, "通过userId获取用户失败");
        }
        user.setStatus(CommonConstant.USER_STATUS_NORMAL);
        userService.insertOrUpdate(user);
        return ResponseEntityBuilder.build(true, null);
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.DELETE)
    @ApiOperation(value = "批量通过ids删除")
    public ResponseEntity<Result> delAllByIds(@RequestParam String[] ids) {

        for (String id : ids) {
            userService.deleteById(id);
            //删除关联角色
            userRoleService.deleteByUserId(id);
        }
        return ResponseEntityBuilder.build(false, "批量通过id删除数据成功");
    }

    @RequestMapping(value = "/needLogin", method = RequestMethod.GET)
    public void needLogin(HttpServletRequest request, HttpServletResponse response) {
        ResponseUtil.out(response, ResponseUtil.resultMap(false,RELOGIN,"请登录"));

    }


}

