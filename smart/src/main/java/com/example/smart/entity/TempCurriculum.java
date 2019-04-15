package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

public class TempCurriculum implements Serializable{
	private static final long serialVersionUID = 2074854935374727462L;
	private Integer tempcurriculumid;   //临时课表id
	private String userid;				//老师id
	private String classroomid;			//教室id
	private Date starttime;				//开始时间
	private Date endtime;				//结束时间
	public Integer getTempcurriculumid() {
		return tempcurriculumid;
	}
	public void setTempcurriculumid(Integer tempcurriculumid) {
		this.tempcurriculumid = tempcurriculumid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getClassroomid() {
		return classroomid;
	}
	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	@Override
	public String toString() {
		return "TempCurriculum [tempcurriculumid=" + tempcurriculumid + ", userid=" + userid + ", classroomid="
				+ classroomid + ", starttime=" + starttime + ", endtime=" + endtime + "]";
	}

	
}
