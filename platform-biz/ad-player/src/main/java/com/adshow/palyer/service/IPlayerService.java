package com.adshow.palyer.service;

import com.adshow.ad.entity.Player;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wmz
 * @since 2018-08-11
 */
public interface IPlayerService extends IService<Player> {

    public void insertUser(String userId,String playerId);

    public boolean isMatched(String userId,String playerId);

}
