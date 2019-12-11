package com.huibur.express.model.entity;

/*******************************************************
 * Copyright(c)2019-2019 HuiBur. All rights reserved.
 * Header: TransContent.java
 * Discussion: 物流轨迹
 * Create Date：2019/9/24
 * Author: Burcy Wen
 * Version: 1.0
 *******************************************************/
public class TransContent {
	/**
	 * 物流轨迹节点内容
	 */
	private String context;
	/**
	 * 时间，原始格式
	 */
	private String time;
	/**
	 * 格式化后时间
	 */
	private String ftime;
	/**
	 * 本数据元对应的签收状态。只有在开通签收状态服务（见上面"status"后的说明）且在订阅接口中提交resultv2标记后才会出现
	 */
	private String status;
	/**
	 * 本数据元对应的行政区域的编码，只有在开通签收状态服务（见上面"status"后的说明）且在订阅接口中提交resultv2标记后才会出现
	 */
	private String areaCode;
	/**
	 * 本数据元对应的行政区域的名称，开通签收状态服务（见上面"status"后的说明）且在订阅接口中提交resultv2标记后才会出现
	 */
	private String areaName;

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFtime() {
		return ftime;
	}

	public void setFtime(String ftime) {
		this.ftime = ftime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}
