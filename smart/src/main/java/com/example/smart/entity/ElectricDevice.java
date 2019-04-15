package com.example.smart.entity;

import java.io.Serializable;

/***
 * 电子班牌 和 教室 班牌 管理 
 * @author Administrator
 *
 */
public class ElectricDevice implements Serializable {
	private static final long serialVersionUID = 1283787714305797866L;
	private String edeviceip; //ip
	private String edevicename;//设备名
	private String ip;//facepp的ip
	private String classroomname;//教室名
	private String classroomid;//教室id
	private String xml;//xml ;
	private  int  type;//type 为零时为电子班牌  type 为 1时 为教室班牌
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getEdeviceip() {
		return edeviceip;
	}
	public void setEdeviceip(String edeviceip) {
		this.edeviceip = edeviceip;
	}
	public String getEdevicename() {
		return edevicename;
	}
	public void setEdevicename(String edevicename) {
		this.edevicename = edevicename;
	}
	public String getClassroomname() {
		return classroomname;
	}
	public void setClassroomname(String classroomname) {
		this.classroomname = classroomname;
	}
	public String getClassroomid() {
		return classroomid;
	}
	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
	}
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public ElectricDevice(String edeviceip, String edevicename, String ip, String classroomname, String classroomid,
			String xml, int type) {
		super();
		this.edeviceip = edeviceip;
		this.edevicename = edevicename;
		this.ip = ip;
		this.classroomname = classroomname;
		this.classroomid = classroomid;
		this.xml = xml;
		this.type = type;
	}
	@Override
	public String toString() {
		return "ElectricDevice [edeviceip=" + edeviceip + ", edevicename=" + edevicename + ", ip=" + ip
				+ ", classroomname=" + classroomname + ", classroomid=" + classroomid + ", xml=" + xml + ", type="
				+ type + "]";
	}
	public ElectricDevice() {
		super();
	}
	

	
	
}
