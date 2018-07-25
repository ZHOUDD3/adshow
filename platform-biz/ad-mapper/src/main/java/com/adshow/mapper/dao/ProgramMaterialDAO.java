package com.adshow.mapper.dao;

import com.adshow.mapper.entity.ProgramMaterial;
import com.adshow.mapper.entity.ProgramMaterialExample;
import org.springframework.stereotype.Repository;

/**
 * ProgramMaterialDAO继承基类
 */
@Repository
public interface ProgramMaterialDAO extends MyBatisBaseDao<ProgramMaterial, Integer, ProgramMaterialExample> {
}