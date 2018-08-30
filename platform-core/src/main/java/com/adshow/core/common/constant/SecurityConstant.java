package com.adshow.core.common.constant;

/**
 *
 */
public interface SecurityConstant {

    /**
     * token分割
     */
    String TOKEN_SPLIT = "Bearer ";

    /**
     * JWT签名加密key
     */
    String JWT_SIGN_KEY = "xboot";

    /**
     * token参数头
     */
    String HEADER = "accessToken";

    /**
     * 权限参数头
     */
    String AUTHORITIES = "authorities";

    /**
     * 用户选择JWT保存时间参数头
     */
    String SAVE_LOGIN = "saveLogin";

    /**
     * 验证码标识
     */
    String KAPTCHA = "kaptcha";

    /**
     * 登录次数标识
     */

    String LOGIN_COUNT = "login_try_count";
}
