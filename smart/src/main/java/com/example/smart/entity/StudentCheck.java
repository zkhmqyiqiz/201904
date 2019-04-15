package com.example.smart.entity;

import java.io.Serializable;

public class StudentCheck implements Serializable{
	private static final long serialVersionUID = 6918039858927342045L;
	private String userid;
	private Long lessonid;
	private String xnxqh;
	private Integer alreadyclass;
	private Integer late;
	private Float attendance;
	private Integer absence;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Long getLessonid() {
		return lessonid;
	}

	public void setLessonid(Long lessonid) {
		this.lessonid = lessonid;
	}

	public String getXnxqh() {
		return xnxqh;
	}

	public void setXnxqh(String xnxqh) {
		this.xnxqh = xnxqh;
	}

	public Integer getAlreadyclass() {
		return alreadyclass;
	}

	public void setAlreadyclass(Integer alreadyclass) {
		this.alreadyclass = alreadyclass;
	}

	public Integer getLate() {
		return late;
	}

	public void setLate(Integer late) {
		this.late = late;
	}

	public Float getAttendance() {
		return attendance;
	}

	public void setAttendance(Float attendance) {
		this.attendance = attendance;
	}

	public Integer getAbsence() {
		return absence;
	}

	public void setAbsence(Integer absence) {
		this.absence = absence;
	}

}
