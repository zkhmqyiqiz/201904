package com.example.smart.entity;

import java.util.Date;

public class TerminalTime {
	private Boolean success;
	private Date StartTime;
	private Integer Projector_OpenTime;
	private Integer FPD_OpenTime;
	private Integer Record_OpenTime;
	private Integer Lesson_OpenTime;
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Date getStartTime() {
		return StartTime;
	}
	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}
	public Integer getProjector_OpenTime() {
		return Projector_OpenTime;
	}
	public void setProjector_OpenTime(Integer projector_OpenTime) {
		Projector_OpenTime = projector_OpenTime;
	}
	public Integer getFPD_OpenTime() {
		return FPD_OpenTime;
	}
	public void setFPD_OpenTime(Integer fPD_OpenTime) {
		FPD_OpenTime = fPD_OpenTime;
	}
	public Integer getRecord_OpenTime() {
		return Record_OpenTime;
	}
	public void setRecord_OpenTime(Integer record_OpenTime) {
		Record_OpenTime = record_OpenTime;
	}
	public Integer getLesson_OpenTime() {
		return Lesson_OpenTime;
	}
	public void setLesson_OpenTime(Integer lesson_OpenTime) {
		Lesson_OpenTime = lesson_OpenTime;
	}
	public TerminalTime(Boolean success, Date startTime, Integer projector_OpenTime, Integer fPD_OpenTime,
			Integer record_OpenTime, Integer lesson_OpenTime) {
		super();
		this.success = success;
		StartTime = startTime;
		Projector_OpenTime = projector_OpenTime;
		FPD_OpenTime = fPD_OpenTime;
		Record_OpenTime = record_OpenTime;
		Lesson_OpenTime = lesson_OpenTime;
	}
	public TerminalTime() {
		super();
		// TODO 自动生成的构造函数存根
	}
	@Override
	public String toString() {
		return "TerminalTime [success=" + success + ", StartTime=" + StartTime + ", Projector_OpenTime="
				+ Projector_OpenTime + ", FPD_OpenTime=" + FPD_OpenTime + ", Record_OpenTime=" + Record_OpenTime
				+ ", Lesson_OpenTime=" + Lesson_OpenTime + "]";
	}
	
	
}
