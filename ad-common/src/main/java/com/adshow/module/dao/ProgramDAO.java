package com.adshow.module.dao;

import com.adshow.module.entity.Program;
import com.adshow.module.entity.ProgramExample;
import org.springframework.stereotype.Repository;

/**
 * ProgramDAO继承基类
 */
@Repository
public interface ProgramDAO extends MyBatisBaseDao<Program, String, ProgramExample> {
}