package com.example.smart.entity;

import java.io.Serializable;

public class AttendClass implements Serializable{
	private static final long serialVersionUID = 5152898009942364415L;
	private Integer attendclassid;
	private Long curriculumid;
	private Integer zc;
	private Integer pptid;
	private Integer attendclasstype;
	public Integer getAttendclassid() {
		return attendclassid;
	}
	public void setAttendclassid(Integer attendclassid) {
		this.attendclassid = attendclassid;
	}
	public Long getCurriculumid() {
		return curriculumid;
	}
	public void setCurriculumid(Long curriculumid) {
		this.curriculumid = curriculumid;
	}
	public Integer getZc() {
		return zc;
	}
	public void setZc(Integer zc) {
		this.zc = zc;
	}
	public Integer getPptid() {
		return pptid;
	}
	public void setPptid(Integer pptid) {
		this.pptid = pptid;
	}
	public Integer getAttendclasstype() {
		return attendclasstype;
	}
	public void setAttendclasstype(Integer attendclasstype) {
		this.attendclasstype = attendclasstype;
	}
	public AttendClass(Integer attendclassid, Long curriculumid, Integer zc, Integer pptid,
			Integer attendclasstype) {
		super();
		this.attendclassid = attendclassid;
		this.curriculumid = curriculumid;
		this.zc = zc;
		this.pptid = pptid;
		this.attendclasstype = attendclasstype;
	}
	public AttendClass() {
		super();
	}
	@Override
	public String toString() {
		return "AttendClass [attendclassid=" + attendclassid + ", curriculumid=" + curriculumid + ", zc=" + zc
				+ ", pptid=" + pptid + ", attendclasstype=" + attendclasstype + "]";
	}
	
}
