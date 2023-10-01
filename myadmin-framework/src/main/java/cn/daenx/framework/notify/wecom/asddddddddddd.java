package cn.daenx.framework.notify.wecom;

import cn.daenx.framework.common.utils.MyUtil;
import cn.daenx.framework.common.vo.system.config.SysFeishuConfigVo;
import cn.daenx.framework.common.vo.system.config.SysWecomConfigVo;
import cn.daenx.framework.notify.feishu.vo.FeishuSendResult;
import cn.daenx.framework.notify.wecom.vo.WecomSendResult;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class asddddddddddd {
    public static void main(String[] args) {
        SysWecomConfigVo configVo = new SysWecomConfigVo( "b5caa377-c430-43e7-8f00-3d656ed93b12", null, null);
        JSONObject req = new JSONObject();
        req.put("msgtype", "text");
        JSONObject text = new JSONObject();
        text.put("content", "阿萨德");
        req.put("text", text);
        WecomSendResult 测试 = sendMsg(configVo, req.toJSONString());
        System.out.println(测试);
    }

    /**
     * 发送企业微信群通知_实际算法
     *
     * @param configVo
     * @param content
     * @return
     */
    public static WecomSendResult sendMsg(SysWecomConfigVo configVo, String content) {
        if (ObjectUtil.isEmpty(configVo)) {
            return new WecomSendResult(false, 9999, "系统企业微信通知配置不可用", null);
        }
        String url = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=" + configVo.getKey();
        String body = HttpRequest.post(url).header("Content-Type", "application/json").body(content).execute().body();
        if (ObjectUtil.isEmpty(body)) {
            return new WecomSendResult(false, 9999, "请求接收为空", null);
        }
        JSONObject jsonObject = JSONObject.parseObject(body);
        Integer code = jsonObject.getInteger("errcode");
        if (code == 0) {
            return new WecomSendResult(true, code, jsonObject.getString("errmsg"), null);
        }
        return new WecomSendResult(false, code, jsonObject.getString("errmsg"), null);
    }


}
