package com.example.smart.entity;

import java.io.Serializable;

/**
 * 教室信息
 * @author Administrator
 *
 */
public class Classroom implements Serializable{
	private static final long serialVersionUID = 6640352137522865825L;
	private String classroomid;		//教室id 主键
	private Integer classroomtype;	//教室类型
	private String classroomname;	//教室名
	private Integer buildnumber;	
	private Integer state;			//状态
	private String classroomtag;	//备注
	private String location;		//位置坐标
	private Integer tjoinnumber;
	
	
	
	public Integer getTjoinnumber() {
		return tjoinnumber;
	}
	public void setTjoinnumber(Integer tjoinnumber) {
		this.tjoinnumber = tjoinnumber;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getClassroomid() {
		return classroomid;
	}
	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
	}
	
	public Integer getClassroomtype() {
		return classroomtype;
	}
	public void setClassroomtype(Integer classroomtype) {
		this.classroomtype = classroomtype;
	}
	public String getClassroomname() {
		return classroomname;
	}
	public void setClassroomname(String classroomname) {
		this.classroomname = classroomname;
	}
	
	public String getClassroomtag() {
		return classroomtag;
	}
	public void setClassroomtag(String classroomtag) {
		this.classroomtag = classroomtag;
	}
	public Integer getBuildnumber() {
		return buildnumber;
	}
	public void setBuildnumber(Integer buildnumber) {
		this.buildnumber = buildnumber;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	public Classroom(String classroomid, Integer classroomtype, String classroomname, Integer buildnumber,
			Integer state, String classroomtag, String location) {
		super();
		this.classroomid = classroomid;
		this.classroomtype = classroomtype;
		this.classroomname = classroomname;
		this.buildnumber = buildnumber;
		this.state = state;
		this.classroomtag = classroomtag;
		this.location = location;
	}
	public Classroom() {
		super();
	}
	
}
