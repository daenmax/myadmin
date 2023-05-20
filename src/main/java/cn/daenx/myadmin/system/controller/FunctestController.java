package cn.daenx.myadmin.system.controller;

import cn.daenx.myadmin.common.utils.DingTalkUtil;
import cn.daenx.myadmin.common.utils.EmailUtil;
import cn.daenx.myadmin.common.utils.SmsUtil;
import cn.daenx.myadmin.common.vo.Result;
import cn.daenx.myadmin.system.vo.system.DingTalkSendResult;
import cn.daenx.myadmin.system.vo.system.SendEmailVo;
import cn.daenx.myadmin.system.vo.system.SendSmsVo;
import cn.daenx.myadmin.system.vo.system.SmsSendResult;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SaIgnore
@RestController
@RequestMapping("/system/functest")
public class FunctestController {


    /**
     * 邮箱测试
     *
     * @return
     */
    @PostMapping("/sendEmail")
    public Result sendEmail(@Validated @RequestBody SendEmailVo vo) {
        Boolean res;
        if (ObjectUtil.isEmpty(vo.getFormEmail())) {
            res = EmailUtil.sendEmail(vo.getToEmail(), vo.getSubject(), vo.getContent(), false, null);
        } else {
            res = EmailUtil.sendEmail(vo.getToEmail(), vo.getSubject(), vo.getContent(), false, null, vo.getFormEmail());
        }
        return res ? Result.ok("发送成功", null) : Result.error("发送失败");
    }

    /**
     * 短信测试
     *
     * @return
     */
    @PostMapping("/sendSms")
    public Result sendSms(@Validated @RequestBody SendSmsVo vo) {
        //腾讯云
//        Map<String, String> map1 = new HashMap<>();
//        map1.put("1", "1234");
//        map1.put("2", "8888");
//        SmsSendResult smsSendResult = SmsUtil.sendSms("+8618731055555,+8618754158888", "1794869", map1,"tencent");
        //阿里云
        Map<String, String> map2 = new HashMap<>();
        map2.put("code", "6666");
        SmsSendResult smsSendResult = SmsUtil.sendSms("+8618731055555,+8618754158888", "SMS_46075548111", map2, "aliyun");
        return Result.ok(smsSendResult);
    }

    /**
     * 测试钉钉群通知
     *
     * @return
     */
    @PostMapping("/sendDingTalk")
    public Result sendDingTalk() {
        //发送普通文本消息
//        List<DingTalkSendResult> dingTalkSendResults = DingTalkUtil.sendTalk("testbot", "测试普通文本消息");
        //自己组装复杂的消息，以便发送其他消息类型的消息
        List<DingTalkSendResult> dingTalkSendResults = DingTalkUtil.sendTalkContent("testbot", "{\"msgtype\":\"markdown\",\"markdown\":{\"title\":\"杭州天气\",\"text\":\"#### 杭州天气 @150XXXXXXXX \\n > 9度，西北风1级，空气良89，相对温度73%\\n > ![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png)\\n > ###### 10点20分发布 [天气](https://www.dingtalk.com) \\n\"},\"at\":{\"atMobiles\":[\"150XXXXXXXX\"],\"atUserIds\":[\"user123\"],\"isAtAll\":false}}");
        return Result.ok(dingTalkSendResults);
    }

}
