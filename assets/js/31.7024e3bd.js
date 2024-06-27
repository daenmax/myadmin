(window.webpackJsonp=window.webpackJsonp||[]).push([[31],{363:function(t,s,a){"use strict";a.r(s);var n=a(8),e=Object(n.a)({},(function(){var t=this,s=t._self._c;return s("ContentSlotsDistributor",{attrs:{"slot-key":t.$parent.slotKey}},[s("h2",{attrs:{id:"说明"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#说明"}},[t._v("#")]),t._v(" 说明")]),t._v(" "),s("p",[t._v("框架内已经实现了"),s("code",[t._v("腾讯云")]),t._v("和"),s("code",[t._v("阿里云")]),t._v("的发送短信API，如果有其他平台需求，可以实现"),s("code",[t._v("SmsService")]),t._v("的"),s("code",[t._v("sendSms")]),t._v("接口")]),t._v(" "),s("p",[t._v("在使用之前，你需要在系统参数里进行配置一下")]),t._v(" "),s("p",[t._v("参数名为："),s("code",[t._v("sys.sms.config")])]),t._v(" "),s("p",[t._v("配置完之后，可以在 "),s("code",[t._v("系统工具-功能测试")]),t._v(" 页面进行测试")]),t._v(" "),s("h2",{attrs:{id:"使用"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#使用"}},[t._v("#")]),t._v(" 使用")]),t._v(" "),s("p",[t._v("直接静态调用"),s("code",[t._v("SmsUtil")]),t._v("工具类里的"),s("code",[t._v("sendSms")]),t._v("方法即可，有两个重载方法")]),t._v(" "),s("div",{staticClass:"language-java extra-class"},[s("pre",{pre:!0,attrs:{class:"language-java"}},[s("code",[t._v("\n    "),s("span",{pre:!0,attrs:{class:"token comment"}},[t._v("/**\n     * 发送短信\n     * <p>\n     * <h4>关于phones参数</h4><br>\n     * 腾讯云：格式为+[国家或地区码][手机号]，单次请求最多支持200个手机号且要求全为境内手机号或全为境外手机号，发送国内短信格式还支持0086、86或无任何国家或地区码的11位手机号码，前缀默认为+86。<br><br>\n     * 阿里云：国内短信：+/+86/0086/86或无任何前缀的11位手机号码，例如1390000****。国际/港澳台消息：国际区号+号码，例如852000012****。单次上限为1000个手机号码\n     * </p>\n     * <p>\n     * <h4>关于param参数</h4><br>\n     * 腾讯云：例如模板为：例如模板为：验证码为：{1}，有效期为{2}分钟，如非本人操作，请忽略本短信。那么key=1，value=6666，key=2，value=5<br><br>\n     * 阿里云：例如模板为：您的验证码为：${code}，请勿泄露于他人！那么key=code，value=1234\n     * </p>\n     *\n     * @param phones     多个手机号用,隔开\n     * @param templateId\n     * @param param\n     * @return\n     */")]),t._v("\n    "),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("SmsSendResult")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token function"}},[t._v("sendSms")]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),t._v(" phones"),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),t._v(" templateId"),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("Map")]),s("span",{pre:!0,attrs:{class:"token generics"}},[s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("<")]),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(">")])]),t._v(" param"),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(";")]),t._v("\n\n    "),s("span",{pre:!0,attrs:{class:"token comment"}},[t._v("/**\n     * 发送短信\n     * <p>\n     * <h4>关于phones参数</h4><br>\n     * 腾讯云：格式为+[国家或地区码][手机号]，单次请求最多支持200个手机号且要求全为境内手机号或全为境外手机号，发送国内短信格式还支持0086、86或无任何国家或地区码的11位手机号码，前缀默认为+86。<br><br>\n     * 阿里云：国内短信：+/+86/0086/86或无任何前缀的11位手机号码，例如1390000****。国际/港澳台消息：国际区号+号码，例如852000012****。单次上限为1000个手机号码\n     * </p>\n     * <p>\n     * <h4>关于param参数</h4><br>\n     * 腾讯云：例如模板为：例如模板为：验证码为：{1}，有效期为{2}分钟，如非本人操作，请忽略本短信。那么key=1，value=6666，key=2，value=5<br><br>\n     * 阿里云：例如模板为：您的验证码为：${code}，请勿泄露于他人！那么key=code，value=1234\n     * </p>\n     *\n     * @param phones     多个手机号用,隔开\n     * @param templateId\n     * @param param\n     * @param type       指定平台，aliyun=阿里云，tencent=腾讯云\n     * @return\n     */")]),t._v("\n    "),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("SmsSendResult")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token function"}},[t._v("sendSms")]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),t._v(" phones"),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),t._v(" templateId"),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("Map")]),s("span",{pre:!0,attrs:{class:"token generics"}},[s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("<")]),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(">")])]),t._v(" param"),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),t._v(" type"),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(";")]),t._v("\n")])])]),s("h2",{attrs:{id:"配置说明"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#配置说明"}},[t._v("#")]),t._v(" 配置说明")]),t._v(" "),s("table",[s("thead",[s("tr",[s("th",[t._v("config节点")]),t._v(" "),s("th",[t._v("说明")]),t._v(" "),s("th",[t._v("取值")])])]),t._v(" "),s("tbody",[s("tr",[s("td",[t._v("type")]),t._v(" "),s("td",[t._v("使用平台，要使用哪个平台进行发送短信")]),t._v(" "),s("td",[t._v("在platform节点中定义了，并且代码中有相应实现")])])])]),t._v(" "),s("table",[s("thead",[s("tr",[s("th",[t._v("platform节点")]),t._v(" "),s("th",[t._v("说明")]),t._v(" "),s("th",[t._v("取值")])])]),t._v(" "),s("tbody",[s("tr",[s("td",[t._v("xxx")]),t._v(" "),s("td",[t._v("你定义的平台名称，例如aliyun、tencent")]),t._v(" "),s("td",[t._v("aliyun=阿里云，tencent=腾讯云")])])])]),t._v(" "),s("h2",{attrs:{id:"框架已经实现的平台的配置说明"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#框架已经实现的平台的配置说明"}},[t._v("#")]),t._v(" 框架已经实现的平台的配置说明")]),t._v(" "),s("table",[s("thead",[s("tr",[s("th",[t._v("aliyun节点")]),t._v(" "),s("th",[t._v("说明")]),t._v(" "),s("th",[t._v("取值")])])]),t._v(" "),s("tbody",[s("tr",[s("td",[t._v("enable")]),t._v(" "),s("td",[t._v("是否启用该平台")]),t._v(" "),s("td",[t._v("true/false")])]),t._v(" "),s("tr",[s("td",[t._v("endpoint")]),t._v(" "),s("td",[t._v("域名")]),t._v(" "),s("td",[t._v("固定为：dysmsapi.aliyuncs.com")])]),t._v(" "),s("tr",[s("td",[t._v("accessKeyId")]),t._v(" "),s("td",[t._v("秘钥ID")]),t._v(" "),s("td",[t._v("你懂得")])]),t._v(" "),s("tr",[s("td",[t._v("accessKeySecret")]),t._v(" "),s("td",[t._v("秘钥KEY")]),t._v(" "),s("td",[t._v("你懂得")])]),t._v(" "),s("tr",[s("td",[t._v("signName")]),t._v(" "),s("td",[t._v("签名")]),t._v(" "),s("td",[t._v("你懂得")])])])]),t._v(" "),s("table",[s("thead",[s("tr",[s("th",[t._v("tencent节点")]),t._v(" "),s("th",[t._v("说明")]),t._v(" "),s("th",[t._v("取值")])])]),t._v(" "),s("tbody",[s("tr",[s("td",[t._v("enable")]),t._v(" "),s("td",[t._v("是否启用该平台")]),t._v(" "),s("td",[t._v("true/false")])]),t._v(" "),s("tr",[s("td",[t._v("endpoint")]),t._v(" "),s("td",[t._v("域名")]),t._v(" "),s("td",[t._v("固定为：sms.tencentcloudapi.com")])]),t._v(" "),s("tr",[s("td",[t._v("accessKeyId")]),t._v(" "),s("td",[t._v("秘钥ID")]),t._v(" "),s("td",[t._v("你懂得")])]),t._v(" "),s("tr",[s("td",[t._v("accessKeySecret")]),t._v(" "),s("td",[t._v("秘钥KEY")]),t._v(" "),s("td",[t._v("你懂得")])]),t._v(" "),s("tr",[s("td",[t._v("signName")]),t._v(" "),s("td",[t._v("签名")]),t._v(" "),s("td",[t._v("你懂得")])]),t._v(" "),s("tr",[s("td",[t._v("sdkAppId")]),t._v(" "),s("td",[t._v("应用ID。腾讯云专属")]),t._v(" "),s("td",[t._v("你懂得")])])])]),t._v(" "),s("h2",{attrs:{id:"示例配置"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#示例配置"}},[t._v("#")]),t._v(" 示例配置")]),t._v(" "),s("div",{staticClass:"language-json extra-class"},[s("pre",{pre:!0,attrs:{class:"language-json"}},[s("code",[s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("{")]),t._v("\n  "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"config"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("{")]),t._v("\n    "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"type"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"aliyun"')]),t._v("\n  "),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("}")]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n  "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"platform"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("{")]),t._v("\n    "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"aliyun"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("{")]),t._v("\n      "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"enable"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"true"')]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n      "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"endpoint"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"dysmsapi.aliyuncs.com"')]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n      "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"accessKeyId"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"LTAI5tNxxxxxxxxxxx6RpcQ9"')]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n      "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"accessKeySecret"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"N9GXxxxxxxxxxxxxxxxxxGPqW8"')]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n      "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"signName"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"MyAdmin"')]),t._v("\n    "),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("}")]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n    "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"tencent"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("{")]),t._v("\n      "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"enable"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"true"')]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n      "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"endpoint"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"sms.tencentcloudapi.com"')]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n      "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"accessKeyId"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"AKID2oPDxxxxxxxxxxxxHfoYZGw"')]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n      "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"accessKeySecret"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"e6JTPxxxxxxxxxxxxxxC5g05"')]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n      "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"signName"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"个人开发记录网"')]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n      "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"sdkAppId"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"1406666693"')]),t._v("\n    "),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("}")]),t._v("\n  "),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("}")]),t._v("\n"),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("}")]),t._v("\n\n")])])])])}),[],!1,null,null,null);s.default=e.exports}}]);