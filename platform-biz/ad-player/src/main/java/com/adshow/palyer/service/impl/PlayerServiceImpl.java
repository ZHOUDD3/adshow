package com.adshow.palyer.service.impl;

import com.adshow.auth.entity.UserPlayer;
import com.adshow.auth.service.IUserPlayerService;
import com.adshow.palyer.service.IPlayerService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adshow.ad.mapper.PlayerMapper;
import com.adshow.ad.entity.Player;

import java.util.Date;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wmz
 * @since 2018-08-11
 */
@Service
public class PlayerServiceImpl extends ServiceImpl<PlayerMapper, Player> implements IPlayerService {

    @Autowired
    private IUserPlayerService userPlayerService;

    private IUserPlayerService getUserPlayerService(){
        return userPlayerService;
    }

    @Override
    public void insertUser(String userId, String playerId) {
        Wrapper<UserPlayer> wrapper = new EntityWrapper<>();
        wrapper.eq("user_id",userId).
                and().eq("player_id",playerId);
        if(getUserPlayerService().selectById(wrapper)==null){
            UserPlayer userPlayer = new UserPlayer();
            userPlayer.setPlayerId(playerId);
            userPlayer.setUserId(userId);
            userPlayer.setCreateTime(new Date());
            getUserPlayerService().insert(userPlayer);
        }

    }

    @Override
    public boolean isMatched(String userId, String playerId) {
        Wrapper<UserPlayer> wrapper = new EntityWrapper<>();
        wrapper.eq("user_id",userId).
                and().eq("player_id",playerId);
        if(getUserPlayerService().selectById(wrapper)!=null){
            return true;
        }
        return false;
    }
}
