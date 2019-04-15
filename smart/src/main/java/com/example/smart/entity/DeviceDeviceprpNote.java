package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 新建的大对象（device，deviceprop，propvalue 三张表的数据） 
 * @author Administrator
 *
 */
public class DeviceDeviceprpNote implements Serializable{
	private static final long serialVersionUID = -2244529730052595863L;
	//设备信息   device
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
	
	//设备属性信息 表  deviceprop
	private Integer propid;//属性ID
	private String propname;//属性名
	//private int devicetype;//设备类型
	
	//设备属性关联表  propvalue
	//private String deviceid;//设备ID
	//private String propid;//属性名
	private String propvalue;//属性值

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

	public Integer getPropid() {
		return propid;
	}

	public void setPropid(Integer propid) {
		this.propid = propid;
	}

	public String getPropname() {
		return propname;
	}

	public void setPropname(String propname) {
		this.propname = propname;
	}

	public String getPropvalue() {
		return propvalue;
	}

	public void setPropvalue(String propvalue) {
		this.propvalue = propvalue;
	}

	public DeviceDeviceprpNote(String deviceid, String devicename, String classroomid, Integer devicetype,
			Date lasttime, String position, Integer servicelife, Date purchasetime, String rtsp, String teg,
			String model, String brand, Integer status, Integer propid, String propname, String propvalue) {
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
		this.propid = propid;
		this.propname = propname;
		this.propvalue = propvalue;
	}

	public DeviceDeviceprpNote() {
		super();
	}

	@Override
	public String toString() {
		return "DeviceDeviceprpNote [deviceid=" + deviceid + ", devicename=" + devicename + ", classroomid="
				+ classroomid + ", devicetype=" + devicetype + ", lasttime=" + lasttime + ", position=" + position
				+ ", servicelife=" + servicelife + ", purchasetime=" + purchasetime + ", rtsp=" + rtsp + ", teg=" + teg
				+ ", model=" + model + ", brand=" + brand + ", status=" + status + ", propid=" + propid + ", propname="
				+ propname + ", propvalue=" + propvalue + "]";
	}
	


	

	
	
}
