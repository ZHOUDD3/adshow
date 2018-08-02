package com.adshow.auth.service;

import com.adshow.auth.entity.Role;
import com.adshow.auth.entity.UserRole;
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
public interface IUserRoleService extends IService<UserRole> {


    /**
     * 通过roleId查找
     * @param roleId
     * @return
     */
    List<UserRole> findByRoleId(String roleId);


    List<Role> findRolesByRoleId(String roleId);

    /**
     * 通过userId删除
     * @param userId
     */
    boolean deleteByUserId(String userId);

}
