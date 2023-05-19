package cn.daenx.myadmin.system.vo.system;

import lombok.Data;

/**
 * 登录
 */
@Data
public class SysLoginVo extends SysSubmitCaptchaVo{

    /**
     * 登录方式
     */
    private String loginType;


    /**
     * 用账号密码登录时
     */
    private String username;
    private String password;

    /**
     * 用短信验证码登录时
     */
    private String phone;

    /**
     * 用邮箱验证码登录时
     */
    private String email;

    /**
     * 验证码
     */
    private String validCode;

    /**
     * 用开放API登录时
     */
    private String apiKey;
}
