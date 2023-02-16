package cn.daenx.myadmin.common.interceptor;

import cn.daenx.myadmin.common.properties.SecurityProperties;
import cn.dev33.satoken.fun.SaParamFunction;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.router.SaRouterStaff;
import cn.dev33.satoken.stp.StpUtil;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SaTokenInterceptor implements WebMvcConfigurer {
    @Resource
    private SecurityProperties securityProperties;

    /**
     * 注册 Sa-Token 拦截器，打开注解式鉴权功能
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册路由拦截器，自定义验证规则
        registry.addInterceptor(new SaInterceptor(handler -> {
                    // 登录验证 -- 排除多个路径
                    SaRouter
                            // 获取所有的
                            .match("/**")
                            // 对未排除的路径进行检查
                            .check(() -> {
                                // 检查是否登录 是否有token
                                StpUtil.checkLogin();

                                // 有效率影响 用于临时测试
                                // if (log.isDebugEnabled()) {
                                //     log.debug("剩余有效时间: {}", StpUtil.getTokenTimeout());
                                //     log.debug("临时有效时间: {}", StpUtil.getTokenActivityTimeout());
                                // }

                            });
                })).addPathPatterns("/**")
                // 排除不需要拦截的路径
                .excludePathPatterns(securityProperties.getExcludes());
    }
}
