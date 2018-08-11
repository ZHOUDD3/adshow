package com.adshow.palyer.service.impl;

import com.adshow.palyer.service.IPlayerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.adshow.ad.mapper.PlayerMapper;
import com.adshow.palyer.entity.Player;

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

}
