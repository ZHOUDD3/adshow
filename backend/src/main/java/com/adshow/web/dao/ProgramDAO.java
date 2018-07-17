package com.adshow.web.dao;

import com.adshow.web.entity.Program;
import com.adshow.web.entity.ProgramExample;
import org.springframework.stereotype.Repository;

/**
 * ProgramDAO继承基类
 */
@Repository
public interface ProgramDAO extends MyBatisBaseDao<Program, String, ProgramExample> {
}