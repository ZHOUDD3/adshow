package com.adshow.module.dao;

import com.adshow.module.entity.PlayerProgram;
import com.adshow.module.entity.PlayerProgramExample;
import org.springframework.stereotype.Repository;

/**
 * PlayerProgramDAO继承基类
 */
@Repository
public interface PlayerProgramDAO extends MyBatisBaseDao<PlayerProgram, Integer, PlayerProgramExample> {
}