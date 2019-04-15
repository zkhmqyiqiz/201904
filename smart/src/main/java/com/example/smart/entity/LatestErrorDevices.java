package com.example.smart.entity;

import java.io.Serializable;

public class LatestErrorDevices implements Serializable {
	private static final long serialVersionUID = 5535907576231500799L;
	private String errortime;           //故障时间
	private String tung;				//楼栋
	private String floor;				//楼层
	private String classroomname; 		//教室名字
	private String teg;					//设备名字
	private String location;
	private String errorname;
	
	public String getErrorname() {
		return errorname;
	}
	public void setErrorname(String errorname) {
		this.errorname = errorname;
	}
	public String getErrortime() {
		return errortime;
	}
	public void setErrortime(String errortime) {
		this.errortime = errortime;
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
	public String getClassroomname() {
		return classroomname;
	}
	public void setClassroomname(String classroomname) {
		this.classroomname = classroomname;
	}
	public String getTeg() {
		return teg;
	}
	public void setTeg(String teg) {
		this.teg = teg;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
