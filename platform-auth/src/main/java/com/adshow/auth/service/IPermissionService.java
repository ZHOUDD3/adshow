package com.adshow.auth.service;

import com.adshow.auth.entity.Permission;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
public interface IPermissionService extends IService<Permission> {

    List<Permission> findByUserId(String userId);


    List<Permission> findByRoleId(String roleId);

    /**
     * 通过parendId查找
     * @param parentId
     * @return
     */
    List<Permission> findByParentId(String parentId);

    List<Permission> getAll();


}
