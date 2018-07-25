package com.adshow.mapper.dao;

import com.adshow.mapper.entity.PlayerProgram;
import com.adshow.mapper.entity.PlayerProgramExample;
import org.springframework.stereotype.Repository;

/**
 * PlayerProgramDAO继承基类
 */
@Repository
public interface PlayerProgramDAO extends MyBatisBaseDao<PlayerProgram, Integer, PlayerProgramExample> {
}