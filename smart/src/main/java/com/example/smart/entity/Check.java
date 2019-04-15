package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

public class Check implements Serializable{
	private static final long serialVersionUID = 418220699613080488L;
	private Long curriculumid;// 课堂id
	private Integer weekid;// 周次
	private Integer shouldpeople;// 应到人数
	private Integer realpeople;// 实到人数
	private Date addtime;// 添加数据的时间
	
	private String subclass;
	private String lessonname;
	private String classroomname;//
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	public Long getCurriculumid() {
		return curriculumid;
	}

	public void setCurriculumid(Long curriculumid) {
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

	public String getClassroomname() {
		return classroomname;
	}

	public void setClassroomname(String classroomname) {
		this.classroomname = classroomname;
	}

	

	public Integer getWeekid() {
		return weekid;
	}

	public void setWeekid(Integer weekid) {
		this.weekid = weekid;
	}

	public Integer getShouldpeople() {
		return shouldpeople;
	}

	public void setShouldpeople(Integer shouldpeople) {
		this.shouldpeople = shouldpeople;
	}

	public Integer getRealpeople() {
		return realpeople;
	}

	public void setRealpeople(Integer realpeople) {
		this.realpeople = realpeople;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

}
