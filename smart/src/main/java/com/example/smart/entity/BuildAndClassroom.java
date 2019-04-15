package com.example.smart.entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 教室-楼栋实体类
 * @see net.smartschool.entity.Classroom
 * @see net.smartschool.entity.Build
 * @author Yangdi
 * @since 201812
 */
public class BuildAndClassroom implements Serializable{
	private static final long serialVersionUID = -2619766549273553633L;
	private int buildnumber;//楼栋编号
	private String tung;//楼栋
	private String floor;//楼层
	private String campus;//校区，前端教学楼同时显示三个
	private Byte[] apartment;//楼层布局图
	private String classroomid;//教室ID
	private String classroomname;//教室名
	private Integer classroomtype;//教室类型  1 实验室 2 一般教室 3 多媒体教室
	private Integer state;//状态
	private String classroomteg;//备注
	private String location;//位置
	private Integer sumtime;
	private Integer tjoinnumber;
	
	
	
	public Integer getTjoinnumber() {
		return tjoinnumber;
	}
	public void setTjoinnumber(Integer tjoinnumber) {
		this.tjoinnumber = tjoinnumber;
	}
	public Integer getSumtime() {
		return sumtime;
	}
	public void setSumtime(Integer sumtime) {
		this.sumtime = sumtime;
	}
	public Byte[] getApartment() {
		return apartment;
	}
	public void setApartment(Byte[] apartment) {
		this.apartment = apartment;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getClassroomteg() {
		return classroomteg;
	}
	public void setClassroomteg(String classroomteg) {
		this.classroomteg = classroomteg;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getBuildnumber() {
		return buildnumber;
	}
	public void setBuildnumber(int buildnumber) {
		this.buildnumber = buildnumber;
	}
	public String getClassroomid() {
		return classroomid;
	}
	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
	}
	public String getTung() {
		return tung;
	}
	public void setTung(String tung) {
		this.tung = tung;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getClassroomname() {
		return classroomname;
	}
	public void setClassroomname(String classroomname) {
		this.classroomname = classroomname;
	}
	public Integer getClassroomtype() {
		return classroomtype;
	}
	public void setClassroomtype(Integer classroomtype) {
		this.classroomtype = classroomtype;
	}
	@Override
	public String toString() {
		return "BuildAndClassroom [buildnumber=" + buildnumber + ", tung=" + tung + ", floor=" + floor + ", campus="
				+ campus + ", apartment=" + Arrays.toString(apartment) + ", classroomid=" + classroomid
				+ ", classroomname=" + classroomname + ", classroomtype=" + classroomtype + ", state=" + state
				+ ", classroomteg=" + classroomteg + ", location=" + location + "]";
	}
	
	
}
