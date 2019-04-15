package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 课表 加了 课程名，教室名
 * 
 * @author Administrator
 *
 */
public class LessonuseNote implements Serializable {
	private static final long serialVersionUID = -2345073430756068031L;
	private Long curriculumid;// 课表id 主键
	private String userid;// 用户名
	private String subclass;// 班级
	private String classroomid;// 教室id
	private int lessoncount;// 应到人数
	private Date time;// 上课时间 大于等于课程开始时间，小于等于结束时间；
	private int lessonid;// 课程id
	private String lessonname;// 课程名
	private String classroomname;// 教室名
	private int weekend;
	private int weekstart;
	private Integer week;
	private Integer lessonjc;

	public Long getCurriculumid() {
		return curriculumid;
	}

	public void setCurriculumid(Long curriculumid) {
		this.curriculumid = curriculumid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSubclass() {
		return subclass;
	}

	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}

	public String getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
	}

	public int getLessoncount() {
		return lessoncount;
	}

	public void setLessoncount(int lessoncount) {
		this.lessoncount = lessoncount;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getLessonid() {
		return lessonid;
	}

	public void setLessonid(int lessonid) {
		this.lessonid = lessonid;
	}

	public String getLessonname() {
		return lessonname;
	}

	public void setLessonname(String lessonname) {
		this.lessonname = lessonname;
	}

	public String getClassroomname() {
		return classroomname;
	}

	public void setClassroomname(String classroomname) {
		this.classroomname = classroomname;
	}


	public int getWeekend() {
		return weekend;
	}

	public void setWeekend(int weekend) {
		this.weekend = weekend;
	}

	public int getWeekstart() {
		return weekstart;
	}

	public void setWeekstart(int weekstart) {
		this.weekstart = weekstart;
	}

	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public Integer getLessonjc() {
		return lessonjc;
	}

	public void setLessonjc(Integer lessonjc) {
		this.lessonjc = lessonjc;
	}

}