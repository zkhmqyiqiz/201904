package com.example.smart.entity;

import java.io.Serializable;

/**
 * 通过数据库当前时间，查询所属学期号、第几周、星期几、处于第几节课（课间时间的话算后面的一节课）、开始时间、结束时间
 */
public class TeamWeekFestivals implements Serializable {
	private static final long serialVersionUID = 636917961594007661L;
	private String xnxqh;// 学年学期号
	private Integer zc;// 周次
	private Integer xqmc;// 星期
	private Integer jc;// 节次
	private String kssj;// 开始时间 例如08:00
	private String jssj;// 结束时间 例如 10:00
	public String getXnxqh() {
		return xnxqh;
	}
	public void setXnxqh(String xnxqh) {
		this.xnxqh = xnxqh;
	}
	public Integer getZc() {
		return zc;
	}
	public void setZc(Integer zc) {
		this.zc = zc;
	}
	public Integer getXqmc() {
		return xqmc;
	}
	public void setXqmc(Integer xqmc) {
		this.xqmc = xqmc;
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


}
