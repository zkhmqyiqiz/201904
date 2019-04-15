package com.example.smart.entity;

import java.io.Serializable;

/**
 * 课表
 * 
 * @author Administrator
 *
 */
public class Lessonuse implements Serializable {
	private static final long serialVersionUID = 4094375380387783826L;
	private Long curriculumid;// 课表id 主键
	private String teacherlessonid;// 老师课堂ID
	private String userid;// 学生ID（学生和老师只有一个存在的时候也可表示老师ID）
	private String classtimeid;// 教室排课ID
	private String subclass;// 班级
	private int lessonid;// 课程ID
	private int weekstart;// 起始周
	private int weekend;// 结束周
	private String curriculumtag;// 备用字段
	private Long lessonuseid;
	private String teacherid;//查询结果中同时存在老师ID和学生ID时候，用teacherid接收老师ID
	public Long getCurriculumid() {
		return curriculumid;
	}
	public void setCurriculumid(Long curriculumid) {
		this.curriculumid = curriculumid;
	}
	public String getTeacherlessonid() {
		return teacherlessonid;
	}
	public void setTeacherlessonid(String teacherlessonid) {
		this.teacherlessonid = teacherlessonid;
	}
	public String getClasstimeid() {
		return classtimeid;
	}
	public void setClasstimeid(String classtimeid) {
		this.classtimeid = classtimeid;
	}
	public String getSubclass() {
		return subclass;
	}
	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}
	public int getWeekstart() {
		return weekstart;
	}
	public void setWeekstart(int weekstart) {
		this.weekstart = weekstart;
	}
	public int getWeekend() {
		return weekend;
	}
	public void setWeekend(int weekend) {
		this.weekend = weekend;
	}
	public String getCurriculumtag() {
		return curriculumtag;
	}
	public void setCurriculumtag(String curriculumtag) {
		this.curriculumtag = curriculumtag;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getLessonid() {
		return lessonid;
	}
	public void setLessonid(int lessonid) {
		this.lessonid = lessonid;
	}
	public Long getLessonuseid() {
		return lessonuseid;
	}
	public void setLessonuseid(Long lessonuseid) {
		this.lessonuseid = lessonuseid;
	}
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	
	


}