package com.adshow.auth.service.impl;

import com.adshow.auth.entity.Resource;
import com.adshow.auth.mapper.ResourceMapper;
import com.adshow.auth.service.IResourceService;
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
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {

}
