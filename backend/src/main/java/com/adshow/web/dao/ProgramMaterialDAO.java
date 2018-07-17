package com.adshow.web.dao;

import com.adshow.web.entity.ProgramMaterial;
import com.adshow.web.entity.ProgramMaterialExample;
import org.springframework.stereotype.Repository;

/**
 * ProgramMaterialDAO继承基类
 */
@Repository
public interface ProgramMaterialDAO extends MyBatisBaseDao<ProgramMaterial, Integer, ProgramMaterialExample> {
}