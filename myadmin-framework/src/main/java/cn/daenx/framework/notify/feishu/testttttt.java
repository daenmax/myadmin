package cn.daenx.framework.notify.feishu;

import cn.daenx.framework.common.utils.MyUtil;
import cn.daenx.framework.common.vo.system.config.SysFeishuConfigVo;
import cn.daenx.framework.notify.feishu.vo.FeishuSendResult;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class testttttt {
    public static void main(String[] args) {
        SysFeishuConfigVo configVo = new SysFeishuConfigVo("【重要通知】", "uPQfTOD7rWVk9a5PIRhFEe", "207b5526-1d06-4398-b3a1-b57ac302626f", null, null);
        JSONObject req = new JSONObject();
        req.put("msg_type", "text");
        JSONObject text = new JSONObject();
        text.put("text", "【重要通知】" + "测试");
        req.put("content", text);
        FeishuSendResult 测试 = sendMsg(configVo, req.toJSONString());
        System.out.println(测试);
    }

    /**
     * 发送飞书群通知_实际算法
     *
     * @param configVo
     * @param content
     * @return
     */
    public static FeishuSendResult sendMsg(SysFeishuConfigVo configVo, String content) {
        if (ObjectUtil.isEmpty(configVo)) {
            return new FeishuSendResult(false, 9999, "系统飞书通知配置不可用", null);
        }
        if (ObjectUtil.isNotEmpty(configVo.getSecret())) {
            try {
                String sign = "";
                String timestamp = String.valueOf(MyUtil.getTimestamp10());
                sign = getSign(configVo.getSecret(), timestamp);
                JSONObject jsonObject = JSONObject.parseObject(content);
                jsonObject.put("sign", sign);
                jsonObject.put("timestamp", timestamp);
                content = jsonObject.toJSONString();
            } catch (Exception e) {
                return new FeishuSendResult(false, 9999, "计算签名失败", null);
            }
        }
        String url = "https://open.feishu.cn/open-apis/bot/v2/hook/" + configVo.getAccessToken();
        String body = HttpRequest.post(url).header("Content-Type", "application/json").body(content).execute().body();
        if (ObjectUtil.isEmpty(body)) {
            return new FeishuSendResult(false, 9999, "请求接收为空", null);
        }
        JSONObject jsonObject = JSONObject.parseObject(body);
        Integer code = jsonObject.getInteger("code");
        if (code == 0) {
            return new FeishuSendResult(true, code, jsonObject.getString("msg"), null);
        }
        return new FeishuSendResult(false, code, jsonObject.getString("msg"), null);
    }

    /**
     * 加签模式下，计算签名
     *
     * @param secret
     * @return
     * @throws Exception
     */
    private static String getSign(String secret, String timestamp) throws Exception {
        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(stringToSign.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(new byte[]{});
        String sign =  new String(Base64.encodeBase64(signData));
        return sign;
    }
}
