package com.huibur.express.util;

import com.huibur.express.constant.Constants;
import com.huibur.express.model.param.QueryParams;
import com.huibur.express.model.param.SMSParams;
import com.huibur.express.model.param.SubParams;
import org.springframework.beans.factory.annotation.Value;
import java.util.HashMap;
import java.util.Map;

/*******************************************************
 * Copyright(c)2019-2019 HuiBur. All rights reserved.
 * Header: ExpressUtils.java
 * Discussion: 快递100企业服务接口
 * Create Date：2019/9/24
 * Author: Burcy Wen
 * Version: 1.0
 *******************************************************/
public class ExpressUtils {
    /**
     * 客户授权Key
     */
    @Value("express.key")
    private static String key;
    /**
     * 实时查询customer
     */
    @Value("express.customer")
    private static String customer;
    /**
     * 电子面单secret
     */
    @Value("express.secret")
    private static String secret;
    /**
     * 短信接口userid
     */
    @Value("express.userid")
    private static String userid;
    /**
     * 智能判断授权aiKey
     */
    @Value("express.aiKey")
    private static String aiKey;

    /***
     * Name: synQueryData
     * Discussion: 实时查询快递单号物流轨迹
     * Params:
     *    QueryParams 查询参数
     * Return:
     *      快递物流信息字符串，根据项目使用json工具，自行转换为实体 TransInfo
     ***/
    public static String synQueryData(QueryParams queryParams) {
        StringBuilder param = new StringBuilder("{");
        param.append("\"com\":\"").append(queryParams.getCom()).append("\"");
        param.append(",\"num\":\"").append(queryParams.getNum()).append("\"");
        if(queryParams.getPhone() != null && !queryParams.getPhone().isEmpty()){
            param.append(",\"phone\":\"").append(queryParams.getPhone()).append("\"");
        }
        if(queryParams.getFrom() != null && !queryParams.getFrom().isEmpty()){
            param.append(",\"from\":\"").append(queryParams.getFrom()).append("\"");
        }
        if(queryParams.getTo() != null && !queryParams.getTo().isEmpty()){
            param.append(",\"to\":\"").append(queryParams.getTo()).append("\"");
        }
        if(queryParams.getResultv2() != null && !queryParams.getResultv2().isEmpty()){
            param.append(",\"resultv2\":\"").append(queryParams.getResultv2()).append("\"");
        }
        if(queryParams.getShow() != null && !queryParams.getShow().isEmpty()){
            param.append(",\"show\":\"").append(queryParams.getShow()).append("\"");
        }
        if(queryParams.getOrder() != null && !queryParams.getOrder().isEmpty()){
            param.append(",\"order\":\"").append(queryParams.getOrder()).append("\"");
        }
        param.append("}");

        Map<String, Object> params = new HashMap<>(4);
        params.put("customer", customer);
        String sign = MD5Utils.encode(param + key + customer);
        params.put("sign", sign.toUpperCase());
        params.put("param", param.toString());

        return HttpUtils.post(Constants.API_SYNQUERY, params);
    }

    /***
     * Name: subscribeData
     * Discussion: 提供运单号的物流跟踪信息，一个单交给快递100后，快递100对运单进行监控，如果监控到有更新，就主动将物流跟踪信息推送到贵方的服务器，贵方将之保存到数据库。
     *              然后当用户登录贵方网站、系统或手机APP时，直接从贵方的数据库读取数据，并显示于贵方的网站、系统或手机APP
     * Params:
     *    SubParams 订阅配置参数
     * Return:
     *      提交状态，订阅数据在回调中接收
     ***/
    public String subscribeData(SubParams subParams) {
        StringBuilder param = new StringBuilder("{");
        param.append("\"company\":\"").append(subParams.getCompany()).append("\"");
        param.append(",\"number\":\"").append(subParams.getNumber()).append("\"");
        if(subParams.getFrom() != null && !subParams.getFrom().isEmpty()){
            param.append(",\"from\":\"").append(subParams.getFrom()).append("\"");
        }
        if(subParams.getTo() != null && !subParams.getTo().isEmpty()){
            param.append(",\"to\":\"").append(subParams.getTo()).append("\"");
        }
        param.append(",\"key\":\"").append(subParams.getKey()).append("\"");

        param.append(",\"parameters\":{");
        param.append("\"callbackurl\":\"").append(subParams.getCallbackurl()).append("\"");
        if(subParams.getSalt() != null && !subParams.getSalt().isEmpty()){
            param.append(",\"salt\":\"").append(subParams.getSalt()).append("\"");
        }
        if(subParams.getResultv2() != null && !subParams.getResultv2().isEmpty()){
            param.append(",\"resultv2\":\"").append(subParams.getResultv2()).append("\"");
        }
        if(subParams.getAutoCom() != null && !subParams.getAutoCom().isEmpty()){
            param.append(",\"autoCom\":\"").append(subParams.getAutoCom()).append("\"");
        }
        if(subParams.getInterCom() != null && !subParams.getInterCom().isEmpty()){
            param.append(",\"interCom\":\"").append(subParams.getInterCom()).append("\"");
        }
        if(subParams.getDepartureCountry() != null && !subParams.getDepartureCountry().isEmpty()){
            param.append(",\"departureCountry\":\"").append(subParams.getDepartureCountry()).append("\"");
        }
        if(subParams.getDepartureCom() != null && !subParams.getDepartureCom().isEmpty()){
            param.append(",\"departureCom\":\"").append(subParams.getDepartureCom()).append("\"");
        }
        if(subParams.getDestinationCountry() != null && !subParams.getDestinationCountry().isEmpty()){
            param.append(",\"destinationCountry\":\"").append(subParams.getDestinationCountry()).append("\"");
        }
        if(subParams.getDestinationCom() != null && !subParams.getDestinationCom().isEmpty()){
            param.append(",\"destinationCom\":\"").append(subParams.getDestinationCom()).append("\"");
        }
        if(subParams.getPhone() != null && !subParams.getPhone().isEmpty()){
            param.append(",\"phone\":\"").append(subParams.getPhone()).append("\"");
        }
        param.append("}");

        param.append("}");

        Map<String, Object> params = new HashMap<>(4);
        params.put("schema", "json");
        params.put("param", param.toString());

        return HttpUtils.post(Constants.API_SUBSCRIBE, params);
    }

    /***
     * Name: sendDataBySMS
     * Discussion: 短信发送接口
     * Params:
            SMSParams 短信发送参数
     * Return:
     *      返回发送状态
     ***/
    public static String sendDataBySMS(SMSParams smsParams) {
        Map<String, Object> params = new HashMap<>(4);
        String sign = MD5Utils.encode(key + smsParams.getUserid());
        params.put("userId", smsParams.getUserid());
        params.put("seller", smsParams.getSeller());
        params.put("phone", smsParams.getPhone());
        params.put("tid", smsParams.getTid());
        params.put("content", sign.toUpperCase());
        if (smsParams.getOutorder() != null && !smsParams.getOutorder().isEmpty()){
            params.put("outorder", smsParams.getOutorder());
        }
        return HttpUtils.post(Constants.API_SMS, params);
    }
}


