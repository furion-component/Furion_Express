package com.huibur.express.constant;

/*******************************************************
 * Copyright(c)2019-2019 HuiBur. All rights reserved.
 * Header: Constants.java
 * Discussion: 快递100企业级服务请求接口
 * Create Date：2019/9/24
 * Author: Burcy Wen
 * Version: 1.0
 *******************************************************/
public final class Constants {
    /**
     * 实时查询请求接口
     */
    public static final String API_SYNQUERY = "http://poll.kuaidi100.com/poll/query.do";

    /**
     * 订阅请求接口
     */
    public static final String API_SUBSCRIBE = "http://poll.kuaidi100.com/poll";
    /**
     * 云打印接口
     */
    public static final String API_CLOUD_PRINT = "http://poll.kuaidi100.com/printapi/printtask.do?method=eOrder";

    /**
     * 电子面单接口
     */
    public static final String API_ELE_SHEET = "http://api.kuaidi100.com/eorderapi.do?method=getElecOrder";

    /**
     * 短信发送接口
     */
    public static final String API_SMS = "http://apisms.kuaidi100.com:9502/sms/send.do";
}
