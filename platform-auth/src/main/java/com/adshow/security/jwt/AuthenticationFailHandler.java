package com.adshow.security.jwt;

import com.adshow.core.common.utils.ResponseUtil;
import com.adshow.core.errors.LoginFailLimitException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 *
 */
@Slf4j
@Component
public class AuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Value("${adshow.loginTimeLimit}")
    private Integer loginTimeLimit;

    @Value("${adshow.loginAfterTime}")
    private Integer loginAfterTime;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
            String username = request.getParameter("username");
            //TODO 保存登录错误次数
            ResponseUtil.out(response, ResponseUtil.resultMap(false,500,"用户名或密码错误"));
        } else if (e instanceof DisabledException) {
            ResponseUtil.out(response, ResponseUtil.resultMap(false,500,"账户被禁用，请联系管理员"));
        } else if (e instanceof LoginFailLimitException){
            ResponseUtil.out(response, ResponseUtil.resultMap(false,500,((LoginFailLimitException) e).getMsg()));
        } else {
            ResponseUtil.out(response, ResponseUtil.resultMap(false,500,"登录失败"));
        }
    }

}
