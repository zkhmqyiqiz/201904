package com.example.smart.entity;

import java.io.Serializable;

/**
 * 12.13添加
  *   学年学期号和周次
 * @author Administrator
 *
 */
public class XNXQHAndZC implements Serializable {
	private static final long serialVersionUID = -5268692119775349398L;
	String xnxqh;
	Integer zc;
	Integer jc;
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
	public Integer getJc() {
		return jc;
	}
	public void setJc(Integer jc) {
		this.jc = jc;
	}
	@Override
	public String toString() {
		return "XNXQHAndZC [xnxqh=" + xnxqh + ", zc=" + zc + ", jc=" + jc + "]";
	}
	
	
}
