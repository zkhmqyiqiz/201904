package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

public class IpCall implements Serializable {
	private static final long serialVersionUID = 5029617213873807421L;
	private String userid;//用户名
	private Date startcall;//开始时间
	private Date endcall; //结束时间
	private String edeviceip;// 用户ip
	private int status;//状态
	private String classroomname;//教室名
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getStartcall() {
		return startcall;
	}
	public void setStartcall(Date startcall) {
		this.startcall = startcall;
	}
	public Date getEndcall() {
		return endcall;
	}
	public void setEndcall(Date endcall) {
		this.endcall = endcall;
	}
	public String getEdeviceip() {
		return edeviceip;
	}
	public void setEdeviceip(String edeviceip) {
		this.edeviceip = edeviceip;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getClassroomname() {
		return classroomname;
	}
	public void setClassroomname(String classroomname) {
		this.classroomname = classroomname;
	}
	@Override
	public String toString() {
		return "IpCall [userid=" + userid + ", startcall=" + startcall + ", endcall=" + endcall + ", edeviceip="
				+ edeviceip + ", status=" + status + ", classroomname=" + classroomname + "]";
	}
	public IpCall(String userid, Date startcall, Date endcall, String edeviceip, int status, String classroomname) {
		super();
		this.userid = userid;
		this.startcall = startcall;
		this.endcall = endcall;
		this.edeviceip = edeviceip;
		this.status = status;
		this.classroomname = classroomname;
	}
	public IpCall() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
