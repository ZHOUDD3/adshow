package com.adshow.module.dao;

import com.adshow.module.entity.ProgramMaterial;
import com.adshow.module.entity.ProgramMaterialExample;
import org.springframework.stereotype.Repository;

/**
 * ProgramMaterialDAO继承基类
 */
@Repository
public interface ProgramMaterialDAO extends MyBatisBaseDao<ProgramMaterial, Integer, ProgramMaterialExample> {
}