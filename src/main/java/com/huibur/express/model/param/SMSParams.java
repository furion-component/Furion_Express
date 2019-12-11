package com.huibur.express.model.param;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/*******************************************************
 * Copyright(c)2019-2019 HuiBur. All rights reserved.
 * Header: SMSParams.java
 * Discussion: 短信发送参数
 * Create Date：2019/9/25
 * Author: Burcy Wen
 * Version: 1.0
 *******************************************************/
@Builder
@Data
public class SMSParams {
    /**
     * 短信接口的授权用户ID
     * 必填
     */
    @NonNull
    private String userid;
    /**
     * 商户名称签名；最好用简称，该字段信息会在短信标签处显示。不要超过5个字符
     * 必填
     */
    @NonNull
    private String seller;
    /**
     * 接收短信手机号
     * 必填
     */
    @NonNull
    private String phone;
    /**
     * 短信模板ID
     * 必填
     */
    @NonNull
    private  Long tid;
    /**
     * 短信模板替换内容
     * 必填
     */
    @NonNull
    private String content;
    /**
     * 外部订单号：当该短信发送模板有回调地址时，外部订单号会返回给调用者，方便用户更新数据
     */
    private String outorder;
}
