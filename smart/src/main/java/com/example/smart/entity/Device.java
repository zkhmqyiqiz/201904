package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

public class Device implements Serializable{
	private static final long serialVersionUID = 3841163498409346608L;
	private String deviceid;//设备ID
	private String devicename;//设备名
	private String classroomid;//教室ID
	private Integer devicetype;//设备类型
	private Date lasttime;//最后操作时间
	private String position;//位置
	private Integer servicelife;//使用年限
	private Date purchasetime;//购买时间
	private String rtsp;//rtsp地址
	private String teg;//备注
	private String model;//型号
	private String brand;//品牌
	private Integer status;//状态
	private String devicenumber;//设备标号
	private String devicebarcode;//设备条形码
	private String personliable;//设备负责人
	private Integer failurefrequency;//设备故障次数
	private String userid;//设备负责人工号
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
	public String getClassroomid() {
		return classroomid;
	}
	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
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
	@Override
	public String toString() {
		return "Device [deviceid=" + deviceid + ", devicename=" + devicename + ", classroomid=" + classroomid
				+ ", devicetype=" + devicetype + ", lasttime=" + lasttime + ", position=" + position + ", servicelife="
				+ servicelife + ", purchasetime=" + purchasetime + ", rtsp=" + rtsp + ", teg=" + teg + ", model="
				+ model + ", brand=" + brand + ", status=" + status + "]";
	}
	public Device(String deviceid, String devicename, String classroomid, Integer devicetype, Date lasttime,
			String position, Integer servicelife, Date purchasetime, String rtsp, String teg, String model,
			String brand, Integer status) {
		super();
		this.deviceid = deviceid;
		this.devicename = devicename;
		this.classroomid = classroomid;
		this.devicetype = devicetype;
		this.lasttime = lasttime;
		this.position = position;
		this.servicelife = servicelife;
		this.purchasetime = purchasetime;
		this.rtsp = rtsp;
		this.teg = teg;
		this.model = model;
		this.brand = brand;
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
	public Device() {
		super();
	}
	
	
	
}
