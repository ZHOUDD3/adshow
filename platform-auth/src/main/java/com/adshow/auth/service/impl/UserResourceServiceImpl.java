package com.adshow.auth.service.impl;

import com.adshow.auth.entity.UserResource;
import com.adshow.auth.mapper.UserResourceMapper;
import com.adshow.auth.service.IUserResourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wmz
 * @since 2018-08-13
 */
@Service
public class UserResourceServiceImpl extends ServiceImpl<UserResourceMapper, UserResource> implements IUserResourceService {

}
