package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

public class ClassroomCallNote implements Serializable {
	private static final long serialVersionUID = -7431520589917887765L;
	private String classroomid;//教室id
	private Integer callid;//预约id 主键
	private String userid;//用户名
	private Date callstart;//预约开始时间
	private Date callend;//结束时间
	private String calltype;//预约类型
	private Integer peoplecount;//参加人数
	private Date calltime;//预约发起时间（时间段）
	private Integer process;//预约进程
	private String calltheme;//预约主题
	private String classroomtype;//教室类型
	private String classroomname;//教室名 数据库中没有这个字段，但是某些请求的返回值需要
	private String buildnumber;//楼栋号
	private Integer state;//教室状态
	private String tag;//备注
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
	public String getClassroomtype() {
		return classroomtype;
	}
	public void setClassroomtype(String classroomtype) {
		this.classroomtype = classroomtype;
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
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public ClassroomCallNote(String classroomid, Integer callid, String userid, Date callstart, Date callend,
			String calltype, Integer peoplecount, Date calltime, Integer process, String calltheme,
			String classroomtype, String classroomname, String buildnumber, Integer state, String tag) {
		super();
		this.classroomid = classroomid;
		this.callid = callid;
		this.userid = userid;
		this.callstart = callstart;
		this.callend = callend;
		this.calltype = calltype;
		this.peoplecount = peoplecount;
		this.calltime = calltime;
		this.process = process;
		this.calltheme = calltheme;
		this.classroomtype = classroomtype;
		this.classroomname = classroomname;
		this.buildnumber = buildnumber;
		this.state = state;
		this.tag = tag;
	}
	public ClassroomCallNote() {
		super();
	}
	@Override
	public String toString() {
		return "ClassroomCallNote [classroomid=" + classroomid + ", callid=" + callid + ", userid=" + userid
				+ ", callstart=" + callstart + ", callend=" + callend + ", calltype=" + calltype + ", peoplecount="
				+ peoplecount + ", calltime=" + calltime + ", process=" + process + ", calltheme=" + calltheme
				+ ", classroomtype=" + classroomtype + ", classroomname=" + classroomname + ", buildnumber="
				+ buildnumber + ", state=" + state + ", tag=" + tag + "]";
	}
	
	
}
