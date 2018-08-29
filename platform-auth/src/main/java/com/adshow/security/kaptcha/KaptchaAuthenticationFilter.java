package com.adshow.security.kaptcha;

import com.adshow.core.common.constant.SecurityConstant;
import com.adshow.core.errors.AuthenticationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author martin
 * @Date 2018/8/29
 */
@Slf4j
@Component
public class KaptchaAuthenticationFilter extends OncePerRequestFilter {


    @Value("${adshow.kaptchaUrls}")
        private String kaptchaUrls;


    public KaptchaAuthenticationFilter() {
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String kaptcha = request.getParameter(SecurityConstant.KAPTCHA);
        String captchaId = (String) request.getSession().getAttribute(SecurityConstant.KAPTCHA);
        if(kaptchaUrls!=null && !kaptchaUrls.equals(request.getRequestURI())){
            chain.doFilter(request, response);
        }
        if (captchaId!=null && kaptcha!=null &&!captchaId.equals(kaptcha)) {
            throw new AuthenticationException("wrong kaptcha ...");

        } else {
            chain.doFilter(request, response);
        }
    }
}
