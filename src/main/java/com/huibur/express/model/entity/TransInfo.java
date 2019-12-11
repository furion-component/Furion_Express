package com.huibur.express.model.entity;

import java.util.ArrayList;
import java.util.List;

/*******************************************************
 * Copyright(c)2019-2019 HuiBur. All rights reserved.
 * Header: TransInfo.java
 * Discussion: 快递100实时查询接口返回体
 * Create Date：2019/9/24
 * Author: Burcy Wen
 * Version: 1.0
 *******************************************************/
public class TransInfo {
	/**
	 * 消息体，请忽略
	 */
	private String message;
	/**
	 * 快递单当前状态，包括0在途，1揽收，2疑难，3签收，4退签，5派件，6退回，7转投 等8个状态
	 */
	private Integer state;
	/**
	 * 通讯状态，请忽略
	 */
	private Integer status;
	/**
	 * 快递单明细状态标记，暂未实现，请忽略
	 */
	private String condition;
	/**
	 * 是否签收标记
	 */
	private Integer ischeck;
	/**
	 * 快递公司编码,一律用小写字母
	 */
	private String com;
	/**
	 * 快递单号
	 */
	private String nu;

    /**
     * 物流轨迹集合
	 */
	List<TransContent> data;

	public TransInfo(){
		data = new ArrayList<>();
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Integer getIscheck() {
		return ischeck;
	}

	public void setIscheck(Integer ischeck) {
		this.ischeck = ischeck;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getNu() {
		return nu;
	}

	public void setNu(String nu) {
		this.nu = nu;
	}

	public List<TransContent> getData() {
		return data;
	}

	public void setData(List<TransContent> data) {
		this.data = data;
	}
}
