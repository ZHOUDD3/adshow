package com.adshow.security.jwt;

import com.adshow.core.common.constant.SecurityConstant;
import com.adshow.core.common.utils.ResponseUtil;
import com.adshow.core.errors.LoginFailLimitException;
import lombok.extern.slf4j.Slf4j;
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

import static com.adshow.core.common.constant.StatusConstant.OVER_LOGIN_COUNT;
import static com.adshow.core.common.constant.StatusConstant.WRONG_PASSWORD;

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
            Integer loginCounts  = request.getSession().getAttribute(SecurityConstant.LOGIN_COUNT)!=null ? Integer.valueOf(String.valueOf(request.getSession().getAttribute(SecurityConstant.LOGIN_COUNT))) : 0;
            if(loginCounts>loginTimeLimit){
                ResponseUtil.out(response, ResponseUtil.resultMap(false,OVER_LOGIN_COUNT,"登录超过"+loginTimeLimit+"次,请在"+loginAfterTime+"分钟后尝试登录"));
            }else{
                request.getSession().setAttribute(SecurityConstant.LOGIN_COUNT,loginCounts+1);
                ResponseUtil.out(response, ResponseUtil.resultMap(false,WRONG_PASSWORD,"用户名或密码错误"));
            }
        } else if (e instanceof DisabledException) {
            ResponseUtil.out(response, ResponseUtil.resultMap(false,500,"账户被禁用，请联系管理员"));
        } else if (e instanceof LoginFailLimitException){
            ResponseUtil.out(response, ResponseUtil.resultMap(false,500,((LoginFailLimitException) e).getMsg()));
        } else {
            ResponseUtil.out(response, ResponseUtil.resultMap(false,500,"登录失败"));
        }
    }

}
