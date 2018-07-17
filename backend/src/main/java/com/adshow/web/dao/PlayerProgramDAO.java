package com.adshow.web.dao;

import com.adshow.web.entity.PlayerProgram;
import com.adshow.web.entity.PlayerProgramExample;
import org.springframework.stereotype.Repository;

/**
 * PlayerProgramDAO继承基类
 */
@Repository
public interface PlayerProgramDAO extends MyBatisBaseDao<PlayerProgram, Integer, PlayerProgramExample> {
}