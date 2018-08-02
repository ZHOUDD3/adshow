package com.adshow.auth.mapper;

import com.adshow.auth.entity.Role;
import com.adshow.auth.entity.UserRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 通过用户id获取
     * @param userId
     * @return
     */
    List<Role> findRolesByUserId(@Param("userId") String userId);

}
