package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 设备信息的加强类（教室名用了模糊连表查询的）
 * @author Administrator
 *
 */
public class DeviceNote implements Serializable {
	private static final long serialVersionUID = 8711050254814021794L;
	private String classroomid;//教室id
	private String deviceid; //设备id主键
	private String devicename; //设备名
	private Integer devicetype;//设备类型
	private Date lasttime;//最后操作时间
	private String position;//位置
	private String servicelife;//使用年限
	private Date purchasetime;//购买时间
	private String rtsp;//rtsp地址
	private String teg;//备注
	private String model;//型号
	private String brand;//品牌
	private Integer status;//设备状态
	private String classroomtype;//教室类型
	private String classroomname;//教室 名（用来模糊查询的）
	private String buildnumber;//楼栋编号
	private Integer state;//教室状态
	public String getClassroomid() {
		return classroomid;
	}
	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
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
	public String getServicelife() {
		return servicelife;
	}
	public void setServicelife(String servicelife) {
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
	public String getClassroomtype() {
		return classroomtype;
	}
	public void setClassroomtype(String classroomtype) {
		this.classroomtype = classroomtype;
	}
	public String getClassroomname() {
		return classroomname;
	}
	public void setClassroomname(String classroomname) {
		this.classroomname = classroomname;
	}
	public String getBuildnumber() {
		return buildnumber;
	}
	public void setBuildnumber(String buildnumber) {
		this.buildnumber = buildnumber;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public DeviceNote(String classroomid, String deviceid, String devicename, Integer devicetype, Date lasttime,
			String position, String servicelife, Date purchasetime, String rtsp, String teg, String model, String brand,
			Integer status, String classroomtype, String classroomname, String buildnumber, Integer state) {
		super();
		this.classroomid = classroomid;
		this.deviceid = deviceid;
		this.devicename = devicename;
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
		this.classroomtype = classroomtype;
		this.classroomname = classroomname;
		this.buildnumber = buildnumber;
		this.state = state;
	}
	public DeviceNote() {
		super();
	}
	@Override
	public String toString() {
		return "DeviceNote [classroomid=" + classroomid + ", deviceid=" + deviceid + ", devicename=" + devicename
				+ ", devicetype=" + devicetype + ", lasttime=" + lasttime + ", position=" + position + ", servicelife="
				+ servicelife + ", purchasetime=" + purchasetime + ", rtsp=" + rtsp + ", teg=" + teg + ", model="
				+ model + ", brand=" + brand + ", status=" + status + ", classroomtype=" + classroomtype
				+ ", classroomname=" + classroomname + ", buildnumber=" + buildnumber + ", state=" + state + "]";
	}
	
}
