package com.example.smart.entity;

import java.io.Serializable;

public class ClassroomUsed implements Serializable {
	private static final long serialVersionUID = 3983440138946953314L;
	private String tung;
	private String floor;
	private String classroomname;
	private String state;
	private Integer num;
	private String subclass;
	private String lessonname;
	private String username;
	public ClassroomUsed(String tung, String floor, String classroomname, String state, Integer num, String subclass,
			String lessonname, String username) {
		this.tung = tung;
		this.floor = floor;
		this.classroomname = classroomname;
		this.state = state;
		this.num = num;
		this.subclass = subclass;
		this.lessonname = lessonname;
		this.username = username;
	}
	public ClassroomUsed() {
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getSubclass() {
		return subclass;
	}
	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}
	public String getLessonname() {
		return lessonname;
	}
	public void setLessonname(String lessonname) {
		this.lessonname = lessonname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "ClassroomUsed [tung=" + tung + ", floor=" + floor + ", classroomname=" + classroomname + ", state="
				+ state + ", num=" + num + ", subclass=" + subclass + ", lessonname=" + lessonname + ", username="
				+ username + "]";
	}
	
	
}
