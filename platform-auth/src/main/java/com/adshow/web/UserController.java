package com.adshow.web;

import com.adshow.auth.mapper.entity.User;
import com.adshow.auth.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户管理", tags = "用户管理")
@RestController()
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @ApiOperation(value="新增用户", notes="新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "firstName", value = "姓氏", required = true, dataType = "String"),
            @ApiImplicitParam(name = "lastName", value = "名字", required = true, dataType = "String")
    })
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody long addNewUser (@RequestParam String firstName, @RequestParam String lastName) {
        User user = new User();
        user.setName(firstName);
        userService.saveUser(user);
        LOG.info(user.toString() + " successfully saved into DB");
        return user.getId();
    }


    @ApiOperation(value="查询用户", notes="查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
    })
    @GetMapping(path="/{id}")
    public @ResponseBody User getUserById(@PathVariable("id") long id) {
        LOG.info("Reading user with id " + id + " from database.");
        return userService.getByAccount(String.valueOf(id));
    }

}
