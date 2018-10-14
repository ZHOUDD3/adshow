package com.adshow.auth.service.impl;

import com.adshow.auth.entity.Group;
import com.adshow.auth.mapper.DeptMapper;
import com.adshow.auth.service.IDeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-07-30
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Group> implements IDeptService {

}
