package com.example.smart.entity;

import java.io.Serializable;

public class Build implements Serializable{
	private static final long serialVersionUID = 7369499466358082772L;
	private Integer buildnumber;//楼栋编号
	private String tung;//栋
	private String floor;//楼层
	private String campus;//校区
	private Byte[] apartment;//布局图
	public Byte[] getApartment() {
		return apartment;
	}

	public void setApartment(Byte[] apartment) {
		this.apartment = apartment;
	}

	public Integer getBuildnumber() {
		return buildnumber;
	}

	public void setBuildnumber(Integer buildnumber) {
		this.buildnumber = buildnumber;
	}

	public String getTung() {
		return tung;
	}

	public void setTung(String tung) {
		this.tung = tung;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

}
