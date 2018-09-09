package com.adshow.core.common.constant;

/**
 * @Author martin
 * @Date 2018/8/30
 */
public interface StatusConstant {

    /**
     * 重新登录
     */
    Integer RELOGIN = 10000;

    /**
     * 用户名密码错误
     */
    Integer WRONG_PASSWORD = 10001;

    /**
     *  超过登录请求次数
     */
    Integer OVER_LOGIN_COUNT = 10002;

    /**
     * 验证码错误
     */
    Integer KAPTCH_WRONG = 10003;



}
