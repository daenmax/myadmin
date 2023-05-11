package cn.daenx.myadmin.system.controller;

import cn.daenx.myadmin.common.vo.Result;
import cn.daenx.myadmin.system.service.CaptchaService;
import cn.daenx.myadmin.system.service.SysConfigService;
import cn.dev33.satoken.annotation.SaIgnore;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@SaIgnore
@RestController
@RequestMapping("")
public class CaptchaController {
    @Resource
    private CaptchaService captchaService;
    @Resource
    private SysConfigService sysConfigService;

    /**
     * 获取图片验证码
     *
     * @return
     */
    @GetMapping("/captchaImage")
    public Result captchaImage() {
        HashMap<String, Object> map = captchaService.createCaptchaImgToBase64();
        Boolean lockCaptchaImg = Boolean.parseBoolean(sysConfigService.getConfigByKey("sys.lock.captchaImg"));
        map.put("captchaImgLock", lockCaptchaImg);
        return Result.ok(map);
    }

    /**
     * 测试邮箱机制
     *
     * @return
     */
    @GetMapping("/testEmail")
    public Result testEmail() {
//        SysEmailConfigVo.Email email = EmailUtil.getOneEmailConfig();
//        System.out.println(email.getEmail());
        return Result.ok("");
    }

}
