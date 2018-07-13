package com.adshow.web.module.systemmanager.dao;

import com.adshow.web.module.videomanager.entity.PlayerProgram;
import com.adshow.web.module.videomanager.entity.PlayerProgramExample;
import org.springframework.stereotype.Repository;

/**
 * PlayerProgramDAO继承基类
 */
@Repository
public interface PlayerProgramDAO extends MyBatisBaseDao<PlayerProgram, Integer, PlayerProgramExample> {
}