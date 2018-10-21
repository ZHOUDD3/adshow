package com.adshow.mybatis.interceptor;

import com.adshow.core.common.utils.SnowFlakeUtil;
import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

public class CommonFieldFillHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.getValue("id") == null || StringUtils.isEmpty(metaObject.getValue("id").toString())) {
            setFieldValByName("id", String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId()), metaObject);
        }

        if (metaObject.getValue("updateTime") == null || StringUtils.isEmpty(metaObject.getValue("updateTime").toString())) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }

        if (metaObject.getValue("createTime") == null || StringUtils.isEmpty(metaObject.getValue("createTime").toString())) {
            setFieldValByName("createTime", new Date(), metaObject);
        }

//        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
//            return;
//        }
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        setFieldValByName("updateUser", userDetails.getUsername(), metaObject);
//        setFieldValByName("createTime", userDetails.getUsername(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }

}
