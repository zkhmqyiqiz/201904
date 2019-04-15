package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

public class LessonBatch implements Serializable{
	private static final long serialVersionUID = 8525634271794310120L;
	private Integer lessonid;
	private String lessonname;
	private String lessontype;
	private Date lessonstart;
	private Date lessonend;
	private String describe;
	private Long curriculumid;
	private Date timestart;
	private Date timeend;
	private Integer surecount;
	private String tag;
	//
	private String userid;
	private String username;
	private String subclass;
	private String classroomid;
	private Integer lessoncount;
	private Integer latecount;
	private Integer escapecount;
	private String classroomname;
	private Integer lessonjc;//节次
	private String xnxqh;//学年学期号
	
	
	public Integer getLessonjc() {
		return lessonjc;
	}
	public void setLessonjc(Integer lessonjc) {
		this.lessonjc = lessonjc;
	}
	public String getXnxqh() {
		return xnxqh;
	}
	public void setXnxqh(String xnxqh) {
		this.xnxqh = xnxqh;
	}
	public String getClassroomname() {
		return classroomname;
	}
	public void setClassroomname(String classroomname) {
		this.classroomname = classroomname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getLatecount() {
		return latecount;
	}
	public void setLatecount(Integer latecount) {
		this.latecount = latecount;
	}
	public Integer getEscapecount() {
		return escapecount;
	}
	public void setEscapecount(Integer escapecount) {
		this.escapecount = escapecount;
	}
	private Date time;
	
	public Integer getLessonid() {
		return lessonid;
	}
	public void setLessonid(Integer lessonid) {
		this.lessonid = lessonid;
	}
	public String getLessonname() {
		return lessonname;
	}
	public void setLessonname(String lessonname) {
		this.lessonname = lessonname;
	}
	public String getLessontype() {
		return lessontype;
	}
	public void setLessontype(String lessontype) {
		this.lessontype = lessontype;
	}
	public Date getLessonstart() {
		return lessonstart;
	}
	public void setLessonstart(Date lessonstart) {
		this.lessonstart = lessonstart;
	}
	public Date getLessonend() {
		return lessonend;
	}
	public void setLessonend(Date lessonend) {
		this.lessonend = lessonend;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public Date getTimestart() {
		return timestart;
	}
	public void setTimestart(Date timestart) {
		this.timestart = timestart;
	}
	public Date getTimeend() {
		return timeend;
	}
	public void setTimeend(Date timeend) {
		this.timeend = timeend;
	}
	public Integer getSurecount() {
		return surecount;
	}
	public void setSurecount(Integer surecount) {
		this.surecount = surecount;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
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
	public Integer getLessoncount() {
		return lessoncount;
	}
	public void setLessoncount(Integer lessoncount) {
		this.lessoncount = lessoncount;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Long getCurriculumid() {
		return curriculumid;
	}
	public void setCurriculumid(Long curriculumid) {
		this.curriculumid = curriculumid;
	}
	@Override
	public String toString() {
		return "LessonBatch [lessonid=" + lessonid + ", lessonname=" + lessonname + ", lessontype=" + lessontype
				+ ", lessonstart=" + lessonstart + ", lessonend=" + lessonend + ", describe=" + describe
				+ ", curriculumid=" + curriculumid + ", timestart=" + timestart + ", timeend=" + timeend
				+ ", surecount=" + surecount + ", tag=" + tag + ", userid=" + userid + ", username=" + username
				+ ", subclass=" + subclass + ", classroomid=" + classroomid + ", lessoncount=" + lessoncount
				+ ", latecount=" + latecount + ", escapecount=" + escapecount + ", classroomname=" + classroomname
				+ ", lessonjc=" + lessonjc + ", xnxqh=" + xnxqh + ", time=" + time + "]";
	}
	
	
	
	
	
}
