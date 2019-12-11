package com.huibur.express.model.param;

import lombok.Builder;
import lombok.Data;

/*******************************************************
 * Copyright(c)2019-2019 HuiBur. All rights reserved.
 * Header: SubParams.java
 * Discussion:
 * Create Date：2019/9/24
 * Author: Burcy Wen
 * Version: 1.0
 *******************************************************/
@Builder
@Data
public class SubParams {
    private String  schema; // 返回数据格式，如:json
    private String company; // 订阅的快递公司的编码，一律用小写字母
    private String number; // 订阅的快递单号，单号的最大长度是32个字符
    private String from; // 出发地城市，省-市-区，非必填，填了有助于提升签收状态的判断的准确率，请尽量提供
    private String  to; // 目的地城市，省-市-区，非必填，填了有助于提升签收状态的判断的准确率，且到达目的地后会加大监控频率，请尽量提供
    private String key; // 授权key
    /**
     * 回调返回结构体
     * result : true表示成功，false表示失败。如果提交回调接口的地址失败，30分钟后重新回调，3次仍旧失败的，自动放弃
     * returnCode:
     *      200: 接收成功
     *      500: 服务器错误
     *          其他错误请自行定义
     * message
     *      返回的提示
     */
    private String callbackurl; // 回调接口的地址。如果需要在推送信息回传自己业务参数，可以在回调地址URL后面拼接上去，如示例中的orderId,回调请求使用http的post方式，回调参数名是param，订阅方接收到回调参数后请及时响应，业务处理逻辑尽量异步处理
    private String salt; // 签名用随机字符串。32位自定义字符串。添加该参数，则推送的时候会增加sign给贵司校验消息的可靠性
    private String  resultv2; // 添加此字段表示开通行政区域解析功能。0：关闭（默认），1：开通行政区域解析功能，2：开通行政解析功能并且返回出发、目的及当前城市信息
    private String autoCom; // 添加此字段且将此值设为1，则表示开始智能判断单号所属公司的功能，开启后，company字段可为空,即只传运单号（number字段），我方收到后会根据单号判断出其所属的快递公司（即company字段）。建议只有在无法知道单号对应的快递公司（即company的值）的情况下才开启此功能
    private String interCom; // 添加此字段表示开启国际版，开启后，若订阅的单号（即number字段）属于国际单号，会返回出发国与目的国两个国家的跟踪信息，本功能暂时只支持邮政体系（国际类的邮政小包、EMS）内的快递公司，若单号我方识别为非国际单，即使添加本字段，也不会返回destResult元素组
    private String departureCountry; // 出发国家编码
    private String  departureCom; // 出发的快递公司的编码
    private String destinationCountry; // 目的的快递公司的编码
    private String destinationCom; // 目的的快递公司的编码
    private String phone; // 收件人或寄件人的手机号或固话（顺丰单号必填，也可以填写后四位，如果是固话，请不要上传分机号）

}
