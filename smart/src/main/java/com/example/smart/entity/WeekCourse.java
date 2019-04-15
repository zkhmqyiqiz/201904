package com.example.smart.entity;

import java.io.Serializable;

/**
 *接受老师查询本周/本月/本学期的数据 */
public class WeekCourse implements Serializable {
	private static final long serialVersionUID = 5716088913272862690L;
	private String lessonName;// 课程名称
	private String subClass;// 班级
	private String tung;// 楼栋
	private String floor;// 楼层
	private String classroomName;// 教室名称
	private Integer zc;//周次
	private Integer week;// 星期
	private Integer lessonJc;// 节次
	private String jssj;// 课程结束时间
	private String status;//状态，已授，未授
	private Integer weekstart;//开始周次
	private Integer weekend;//结束周次
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	public String getSubClass() {
		return subClass;
	}
	public void setSubClass(String subClass) {
		this.subClass = subClass;
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
	public String getClassroomName() {
		return classroomName;
	}
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	public Integer getLessonJc() {
		return lessonJc;
	}
	public void setLessonJc(Integer lessonJc) {
		this.lessonJc = lessonJc;
	}
	public String getJssj() {
		return jssj;
	}
	public void setJssj(String jssj) {
		this.jssj = jssj;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getZc() {
		return zc;
	}
	public void setZc(Integer zc) {
		this.zc = zc;
	}
	public Integer getWeekstart() {
		return weekstart;
	}
	public void setWeekstart(Integer weekstart) {
		this.weekstart = weekstart;
	}
	public Integer getWeekend() {
		return weekend;
	}
	public void setWeekend(Integer weekend) {
		this.weekend = weekend;
	}
	
	
}