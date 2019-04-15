package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 教室预约
 * @author Administrator
 *
 */
public class ClassroomCall implements Serializable {
	private static final long serialVersionUID = -5816005737508957387L;
	private Integer callid;//预约id 主键
	private String classroomid;//教室id
	private String userid;//用户名
	private Date callstart;//预约开始时间
	private Date callend;//结束时间
	private String calltype;//预约类型
	private Integer peoplecount;//参加人数
	private Date calltime;//预约发起时间（时间段）
	private Integer process;//预约进程
	private String calltheme;//预约主题
	
	private String classroomname;//教室名 数据库中没有这个字段，但是某些请求的返回值需要
	public String getClassroomid() {
		return classroomid;
	}
	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getCallstart() {
		return callstart;
	}
	public void setCallstart(Date callstart) {
		this.callstart = callstart;
	}
	public Date getCallend() {
		return callend;
	}
	public void setCallend(Date callend) {
		this.callend = callend;
	}
	public String getCalltype() {
		return calltype;
	}
	public void setCalltype(String calltype) {
		this.calltype = calltype;
	}
	public Date getCalltime() {
		return calltime;
	}
	public void setCalltime(Date calltime) {
		this.calltime = calltime;
	}
	public String getCalltheme() {
		return calltheme;
	}
	public void setCalltheme(String calltheme) {
		this.calltheme = calltheme;
	}
	public Integer getProcess() {
		return process;
	}
	public void setProcess(Integer process) {
		this.process = process;
	}
	public void setCallid(Integer callid) {
		this.callid = callid;
	}
	public void setPeoplecount(Integer peoplecount) {
		this.peoplecount = peoplecount;
	}
	
	public String getClassroomname() {
		return classroomname;
	}
	public void setClassroomname(String classroomname) {
		this.classroomname = classroomname;
	}
	public Integer getCallid() {
		return callid;
	}
	public Integer getPeoplecount() {
		return peoplecount;
	}
	public ClassroomCall(Integer callid, String classroomid, String userid, Date callstart, Date callend,
			String calltype, Integer peoplecount, Date calltime, Integer process, String calltheme) {
		super();
		this.callid = callid;
		this.classroomid = classroomid;
		this.userid = userid;
		this.callstart = callstart;
		this.callend = callend;
		this.calltype = calltype;
		this.peoplecount = peoplecount;
		this.calltime = calltime;
		this.process = process;
		this.calltheme = calltheme;
	}
	public ClassroomCall() {
		super();
	}
	@Override
	public String toString() {
		return "ClassRoomCall [callid=" + callid + ", classroomid=" + classroomid + ", userid=" + userid
				+ ", callstart=" + callstart + ", callend=" + callend + ", calltype=" + calltype + ", peoplecount="
				+ peoplecount + ", calltime=" + calltime + ", process=" + process + ", calltheme=" + calltheme + "]";
	}

	
}
