package com.example.smart.entity;

import java.io.Serializable;

public class Vkbjc implements Serializable {
	private static final long serialVersionUID = 8399890761004980594L;
	private String kbjcsjid;// 节次ID
	private String kkjj;// 开课季节
	private Integer jc;// 节次
	private String kssj;// 开始时间
	private String jssj;// 结束时间
	private String xnxq01id;// 学年学期

	public String getKbjcsjid() {
		return kbjcsjid;
	}

	public void setKbjcsjid(String kbjcsjid) {
		this.kbjcsjid = kbjcsjid;
	}

	public String getKkjj() {
		return kkjj;
	}

	public void setKkjj(String kkjj) {
		this.kkjj = kkjj;
	}

	public Integer getJc() {
		return jc;
	}

	public void setJc(Integer jc) {
		this.jc = jc;
	}

	public String getKssj() {
		return kssj;
	}

	public void setKssj(String kssj) {
		this.kssj = kssj;
	}

	public String getJssj() {
		return jssj;
	}

	public void setJssj(String jssj) {
		this.jssj = jssj;
	}

	public String getXnxq01id() {
		return xnxq01id;
	}

	public void setXnxq01id(String xnxq01id) {
		this.xnxq01id = xnxq01id;
	}

}
