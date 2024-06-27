(window.webpackJsonp=window.webpackJsonp||[]).push([[21],{353:function(t,s,a){"use strict";a.r(s);var n=a(8),e=Object(n.a)({},(function(){var t=this,s=t._self._c;return s("ContentSlotsDistributor",{attrs:{"slot-key":t.$parent.slotKey}},[s("h2",{attrs:{id:"说明"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#说明"}},[t._v("#")]),t._v(" 说明")]),t._v(" "),s("p",[t._v("框架内封装"),s("code",[t._v("飞书群机器人")]),t._v("的"),s("code",[t._v("发消息API")]),t._v("，在使用之前，你需要在系统参数里进行配置一下")]),t._v(" "),s("p",[t._v("参数名为："),s("code",[t._v("sys.feishu.config")])]),t._v(" "),s("p",[t._v("配置完之后，可以在 "),s("code",[t._v("系统工具-功能测试")]),t._v(" 页面进行测试")]),t._v(" "),s("h2",{attrs:{id:"使用"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#使用"}},[t._v("#")]),t._v(" 使用")]),t._v(" "),s("p",[t._v("直接静态调用"),s("code",[t._v("FeishuUtil")]),t._v("工具类里的"),s("code",[t._v("sendMsg")]),t._v("、"),s("code",[t._v("sendByContent")]),t._v("方法即可")]),t._v(" "),s("div",{staticClass:"language-java extra-class"},[s("pre",{pre:!0,attrs:{class:"language-java"}},[s("code",[t._v("    "),s("span",{pre:!0,attrs:{class:"token comment"}},[t._v("/**\n * 发送飞书群通知\n * text类型，如果需要其他消息类型，请自己组装报文，然后调用sendByContent方法\n *\n * @param botName 机器人名称，在系统参数里自己填的，多个用,隔开\n * @param msg     消息内容，不需要自己写关键词\n * @return\n */")]),t._v("\n"),s("span",{pre:!0,attrs:{class:"token keyword"}},[t._v("public")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token keyword"}},[t._v("static")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("List")]),s("span",{pre:!0,attrs:{class:"token generics"}},[s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("<")]),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("FeishuSendResult")]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(">")])]),t._v(" "),s("span",{pre:!0,attrs:{class:"token function"}},[t._v("sendMsg")]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),t._v(" botName"),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),t._v(" msg"),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),t._v("\n\n"),s("span",{pre:!0,attrs:{class:"token comment"}},[t._v("/**\n * 发送飞书群通知\n * 自己组装报文，以便实现更多消息类型\n *\n * @param botName 机器人名称，在系统参数里自己填的，多个用,隔开\n * @param content JSON格式的数据，参考飞书官网文档，不需要自己计算签名，但是需要写关键词（如果有的话）\n * @return\n */")]),t._v("\n"),s("span",{pre:!0,attrs:{class:"token keyword"}},[t._v("public")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token keyword"}},[t._v("static")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("List")]),s("span",{pre:!0,attrs:{class:"token generics"}},[s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("<")]),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("FeishuSendResult")]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(">")])]),t._v(" "),s("span",{pre:!0,attrs:{class:"token function"}},[t._v("sendByContent")]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("(")]),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),t._v(" botName"),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token class-name"}},[t._v("String")]),t._v(" content"),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(")")]),t._v("\n")])])]),s("h2",{attrs:{id:"配置说明"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#配置说明"}},[t._v("#")]),t._v(" 配置说明")]),t._v(" "),s("table",[s("thead",[s("tr",[s("th",[t._v("顶部节点")]),t._v(" "),s("th",[t._v("说明")]),t._v(" "),s("th",[t._v("取值")])])]),t._v(" "),s("tbody",[s("tr",[s("td",[t._v("机器人名称")]),t._v(" "),s("td",[t._v("机器人名称")]),t._v(" "),s("td",[t._v("给你的机器人定义一个名字，在调用API的时候，需要传入这个名字")])])])]),t._v(" "),s("p",[t._v("这里解释一下，如果你要实现不同的定时任务异常推送到不同的群，那你就需要在飞书里创建多个群，每个群都创建一个机器人")]),t._v(" "),s("p",[t._v("那你就需要参数里定义多个机器人的信息，给每个机器人定义一个不重复的机器人名字")]),t._v(" "),s("p",[t._v("这样在使用的时候，要往哪个群里发，就用哪个机器人的名字")]),t._v(" "),s("table",[s("thead",[s("tr",[s("th",[t._v("内部节点")]),t._v(" "),s("th",[t._v("说明")])])]),t._v(" "),s("tbody",[s("tr",[s("td",[t._v("keywords")]),t._v(" "),s("td",[t._v("如果启用了关键词，那么需要填写此参数，会直接拼接在消息前面")])]),t._v(" "),s("tr",[s("td",[t._v("secret")]),t._v(" "),s("td",[t._v("如果启用了加签，那么需要填写此参数")])]),t._v(" "),s("tr",[s("td",[t._v("accessToken")]),t._v(" "),s("td",[t._v("WEBHOOK连接里bot/v2/hook/后面的参数，必填")])]),t._v(" "),s("tr",[s("td",[t._v("remark")]),t._v(" "),s("td",[t._v("仅仅是备注，无其他作用")])])])]),t._v(" "),s("h2",{attrs:{id:"示例配置"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#示例配置"}},[t._v("#")]),t._v(" 示例配置")]),t._v(" "),s("div",{staticClass:"language-json extra-class"},[s("pre",{pre:!0,attrs:{class:"language-json"}},[s("code",[s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("{")]),t._v("\n  "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"testbot"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("{")]),t._v("\n    "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"keywords"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('""')]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n    "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"secret"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"uPQfTOD7r***9a5PIRhFEe"')]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n    "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"accessToken"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"207b5526-****-****-****-b57ac302626f"')]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n    "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"remark"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"测试群的机器人"')]),t._v("\n  "),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("}")]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n  "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"xiaobai"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("{")]),t._v("\n    "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"keywords"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"【定时任务异常】"')]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n    "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"secret"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('""')]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n    "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"accessToken"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"307b5526-****-****-****-b57ac302627a"')]),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v(",")]),t._v("\n    "),s("span",{pre:!0,attrs:{class:"token property"}},[t._v('"remark"')]),s("span",{pre:!0,attrs:{class:"token operator"}},[t._v(":")]),t._v(" "),s("span",{pre:!0,attrs:{class:"token string"}},[t._v('"闲聊群的机器人"')]),t._v("\n  "),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("}")]),t._v("\n"),s("span",{pre:!0,attrs:{class:"token punctuation"}},[t._v("}")]),t._v("\n")])])]),s("h2",{attrs:{id:"定时任务使用案例"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#定时任务使用案例"}},[t._v("#")]),t._v(" 定时任务使用案例")]),t._v(" "),s("p",[s("img",{attrs:{src:"/img/%E5%BF%AB%E9%80%9F%E5%BC%80%E5%A7%8B/12.png",alt:""}})])])}),[],!1,null,null,null);s.default=e.exports}}]);