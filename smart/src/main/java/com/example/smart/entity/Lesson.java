package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程基本信息
 * 
 * @author Administrator
 *
 */
public class Lesson implements Serializable {
	private static final long serialVersionUID = -1885387310330974661L;
	private int lessonid;// 课程 ID 主键
	private String lessonname; // 课程名
	private String lessontype;// 课程类型
	private Date lessonstart; // 课程起始时间
	private Date lessonend;// 课程结束时间
	private String describe;// 描述

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


	@Override
	public String toString() {
		return "Lesson [lessonid=" + lessonid + ", lessonname=" + lessonname + ", lessontype=" + lessontype
				+ ", lessonstart=" + lessonstart + ", lessonend=" + lessonend + ", describe=" + describe + "]";
	}

	public Lesson(int lessonid, String lessonname, String lessontype, Date lessonstart, Date lessonend, String describe) {
		super();
		this.lessonid = lessonid;
		this.lessonname = lessonname;
		this.lessontype = lessontype;
		this.lessonstart = lessonstart;
		this.lessonend = lessonend;
		this.describe = describe;
	}

	public Lesson() {
		super();
		// TODO Auto-generated constructor stub
	}

}
