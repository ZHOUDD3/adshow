//package com.adshow.mybatis.interceptor;
//
//import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
//import org.apache.ibatis.reflection.MetaObject;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Date;
//
//public class UpdateMetaHandler extends MetaObjectHandler {
//    @Override
//    public void insertFill(MetaObject metaObject) {
//        Object lastUpdateUser = metaObject.getValue("lastUpdateUser");
//        Object lastUpdateTime = metaObject.getValue("lastUpdateTime");
//
//        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
//            return;
//        }
//
//        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
//            return;
//        }
//
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (null == lastUpdateUser) {
//            metaObject.setValue("lastUpdateUser", userDetails.getUsername());
//        }
//        if (null == lastUpdateTime) {
//            metaObject.setValue("lastUpdateTime", new Date());
//        }
//    }
//
//    @Override
//    public void updateFill(MetaObject metaObject) {
//        insertFill(metaObject);
//    }
//}
