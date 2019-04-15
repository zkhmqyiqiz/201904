package com.example.smart.entity;

import java.io.Serializable;

/**
 * 教室类中加入了 设备名
 * @author Administrator
 *
 */
public class ClassroomNote implements Serializable{
	private static final long serialVersionUID = 4972445186728366302L;
	private String classroomid;//教室id 主键
	private String classroomtype;//教室类型
	private String classroomname;//教室名
	private int cpozitionid;//刷卡机id
	private String tag;//备注
	private String company; // 公司名
	private String cpozitionname;//刷卡机名。
	public String getClassroomid() {
		return classroomid;
	}
	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
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
	public int getCpozitionid() {
		return cpozitionid;
	}
	public void setCpozitionid(int cpozitionid) {
		this.cpozitionid = cpozitionid;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCpozitionname() {
		return cpozitionname;
	}
	public void setCpozitionname(String cpozitionname) {
		this.cpozitionname = cpozitionname;
	}
	@Override
	public String toString() {
		return "ClassroomNote [classroomid=" + classroomid + ", classroomtype=" + classroomtype + ", classroomname="
				+ classroomname + ", cpozitionid=" + cpozitionid + ", tag=" + tag + ", company=" + company
				+ ", cpozitionname=" + cpozitionname + "]";
	}
	public ClassroomNote(String classroomid, String classroomtype, String classroomname, int cpozitionid, String tag,
			String company, String cpozitionname) {
		super();
		this.classroomid = classroomid;
		this.classroomtype = classroomtype;
		this.classroomname = classroomname;
		this.cpozitionid = cpozitionid;
		this.tag = tag;
		this.company = company;
		this.cpozitionname = cpozitionname;
	}
	public ClassroomNote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
