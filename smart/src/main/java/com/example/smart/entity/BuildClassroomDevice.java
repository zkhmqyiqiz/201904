package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

public class BuildClassroomDevice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8840943054233278218L;
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
	private String deviceid;//设备ID
	private String devicename;//设备名称(英文名称)
	private Integer devicetype;//设备类型
	private Date lasttime;//最后操作时间
	private String position;//位置
	private Integer servicelife;//使用年限（寿命周期）
	private Date purchasetime;//购买时间
	private String rtsp;//rtsp地址
	private String teg;//设备名称（中文名称）
	private String model;//型号
	private String brand;//品牌
	private Integer status;//状态
	private String devicenumber;//设备编号
	private String devicebarcode;//设备条形码
	private String personliable;//设备责任人
	private Integer failurefrequency;//设备故障次数
	private String userid;//设备责任的工号
	
	public int getBuildnumber() {
		return buildnumber;
	}

	public void setBuildnumber(int buildnumber) {
		this.buildnumber = buildnumber;
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

	public Byte[] getApartment() {
		return apartment;
	}

	public void setApartment(Byte[] apartment) {
		this.apartment = apartment;
	}

	public String getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
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

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	public Integer getDevicetype() {
		return devicetype;
	}

	public void setDevicetype(Integer devicetype) {
		this.devicetype = devicetype;
	}

	public Date getLasttime() {
		return lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getServicelife() {
		return servicelife;
	}

	public void setServicelife(Integer servicelife) {
		this.servicelife = servicelife;
	}

	public Date getPurchasetime() {
		return purchasetime;
	}

	public void setPurchasetime(Date purchasetime) {
		this.purchasetime = purchasetime;
	}

	public String getRtsp() {
		return rtsp;
	}

	public void setRtsp(String rtsp) {
		this.rtsp = rtsp;
	}

	public String getTeg() {
		return teg;
	}

	public void setTeg(String teg) {
		this.teg = teg;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDevicenumber() {
		return devicenumber;
	}

	public void setDevicenumber(String devicenumber) {
		this.devicenumber = devicenumber;
	}

	public String getDevicebarcode() {
		return devicebarcode;
	}

	public void setDevicebarcode(String devicebarcode) {
		this.devicebarcode = devicebarcode;
	}

	public String getPersonliable() {
		return personliable;
	}

	public void setPersonliable(String personliable) {
		this.personliable = personliable;
	}

	public Integer getFailurefrequency() {
		return failurefrequency;
	}

	public void setFailurefrequency(Integer failurefrequency) {
		this.failurefrequency = failurefrequency;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	

}
