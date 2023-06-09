package cn.daenx.myadmin.system.service;

import cn.daenx.myadmin.system.domain.vo.system.SysCaptchaConfigVo;
import cn.daenx.myadmin.system.domain.vo.system.SysSubmitCaptchaVo;

import java.util.HashMap;

public interface CaptchaService {
    /**
     * 创建验证码
     * 受系统参数配置影响
     *
     * @return
     */
    HashMap<String, Object> createCaptcha();

    /**
     * 创建图片验证码
     *
     * @param sysCaptchaConfigVo
     * @return
     */
    HashMap<String, Object> createCaptchaImgToBase64(SysCaptchaConfigVo sysCaptchaConfigVo);

    /**
     * 创建腾讯滑块验证码
     *
     * @param sysCaptchaConfigVo
     * @return
     */
    HashMap<String, Object> createCaptchaSlider(SysCaptchaConfigVo sysCaptchaConfigVo);

    /**
     * 校验验证码
     *
     * @param vo
     */
    void validatedCaptcha(SysSubmitCaptchaVo vo);
}
