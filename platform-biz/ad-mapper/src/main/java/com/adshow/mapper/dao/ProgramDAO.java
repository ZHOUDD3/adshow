package com.adshow.mapper.dao;

import com.adshow.mapper.entity.Program;
import com.adshow.mapper.entity.ProgramExample;
import org.springframework.stereotype.Repository;

/**
 * ProgramDAO继承基类
 */
@Repository
public interface ProgramDAO extends MyBatisBaseDao<Program, String, ProgramExample> {
}