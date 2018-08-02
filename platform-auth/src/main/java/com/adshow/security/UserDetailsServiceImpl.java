package com.adshow.security;

import com.adshow.auth.entity.User;
import com.adshow.auth.service.IUserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 */
@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService{

    @Value("${adshow.loginAfterTime}")
    private Integer loginAfterTime;

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(false){
            //超过限制次数
            //TODO 自定义异常
            throw new UsernameNotFoundException("登录错误次数超过限制，请"+loginAfterTime+"分钟后再试");
        }
        Wrapper<User> entity = new EntityWrapper<User>();
        entity.eq("username", username);
        User user = userService.selectOne(entity);
        return new SecurityUserDetails(user);
    }
}
