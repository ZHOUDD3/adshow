package com.adshow.mqtt.auth;

import com.adshow.ad.entity.Player;
import com.adshow.palyer.service.IPlayerService;
import io.moquette.spi.security.IAuthenticator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class ValidAuthenticator implements IAuthenticator {
    @Autowired
    private IPlayerService playerService;

    @Override
    public boolean checkValid(String clientId, String username, byte[] password) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("machine_id", clientId);
        List<Player> playerList = playerService.selectByMap(paramsMap);
//        if (CollectionUtils.isEmpty(playerList)) {
//            log.warn("Illegal device attempt to connect, sn: {}", clientId);
//            return false;
//        }

        //根据设备及账号口令做校验
        return true;
    }
}
