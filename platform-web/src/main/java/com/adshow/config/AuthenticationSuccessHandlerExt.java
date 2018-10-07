package com.adshow.config;

import com.adshow.ad.entity.Player;
import com.adshow.palyer.service.IPlayerService;
import com.adshow.security.jwt.AuthenticationSuccessHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class AuthenticationSuccessHandlerExt extends AuthenticationSuccessHandler {

    public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "username";

    @Autowired
    private IPlayerService playerService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        // 设备注册绑定, 下发播放列表
        String userName = request.getParameter(SPRING_SECURITY_FORM_USERNAME_KEY);

        String id = request.getHeader("DEV-ID");
        String ip = request.getHeader("DEV-IP");
        String mac = request.getHeader("DEV-MAC");
        String resolution = StringUtils.replace(request.getHeader("DEV-RESOLUTION"), "*", " x ");
        String version = request.getHeader("DEV-VERSION");
        if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(resolution) && StringUtils.isNotEmpty(version)) {
            Player player = playerService.selectById(id);
            if (player == null) {
                player = new Player();
                player.setId(id);
            }
            player.setMacIp(ip);
            player.setResolution(resolution);
            player.setOsVersion(version);
            playerService.insertOrUpdate(player);
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
