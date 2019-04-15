package com.example.smart.entity;

import java.io.Serializable;

public class ClassKbjc implements Serializable{
	private static final long serialVersionUID = -3419376918877689397L;
	private String kssj;//开始时间
	private String jssj;//结束时间
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
	@Override
	public String toString() {
		return "ClassKbjc [kssj=" + kssj + ", jssj=" + jssj + "]";
	}
	

}
