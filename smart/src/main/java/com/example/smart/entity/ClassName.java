package com.example.smart.entity;

import java.io.Serializable;

/**
 * 通过查询lessonform（timestart这个时间为条件），lessonuse，lesson，electricdevice 查询数据  班级名，课程名
 * @author Administrator
 *
 */
public class ClassName implements Serializable{
	private static final long serialVersionUID = 1507502512782755466L;

	private String subclass;//班级名
	private String lessonname;//课程名
	private long curriculumid;
	
	public long getCurriculumid() {
		return curriculumid;
	}
	public void setCurriculumid(long curriculumid) {
		this.curriculumid = curriculumid;
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
	@Override
	public String toString() {
		return "ClassName [subclass=" + subclass + ", lessonname=" + lessonname + "]";
	}
	public ClassName(String subclass, String lessonname) {
		super();
		this.subclass = subclass;
		this.lessonname = lessonname;
	}
	public ClassName() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
