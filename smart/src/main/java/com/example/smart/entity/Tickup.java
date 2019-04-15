package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

public class Tickup implements Serializable{
	private static final long serialVersionUID = -2676451588524567192L;
	private String userid;//用户名
	private Long curriculumid;//课程id 用来连接课程基本信息表（课程名）
	private String lessonname;//课程名;
	private Date tickuptime;//签到时间;
	private Integer success;//转态 0是成功 1是失败。
	private String username;
	private Integer weekid; //周次
	private Integer tickuptype;//签到类型
	private Integer count;//总数
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLessonname() {
		return lessonname;
	}
	public void setLessonname(String lessonname) {
		this.lessonname = lessonname;
	}
	public Date getTickuptime() {
		return tickuptime;
	}
	public void setTickuptime(Date tickuptime) {
		this.tickuptime = tickuptime;
	}
	
	public Integer getSuccess() {
		return success;
	}
	public void setSuccess(Integer success) {
		this.success = success;
	}
	public Integer getWeekid() {
		return weekid;
	}
	public void setWeekid(Integer weekid) {
		this.weekid = weekid;
	}
	public Long getCurriculumid() {
		return curriculumid;
	}
	public void setCurriculumid(Long curriculumid) {
		this.curriculumid = curriculumid;
	}
	public Integer getTickuptype() {
		return tickuptype;
	}
	public void setTickuptype(Integer tickuptype) {
		this.tickuptype = tickuptype;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	
	
}
