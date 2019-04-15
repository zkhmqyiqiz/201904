package com.example.smart.entity;

import java.io.Serializable;

/**
  *  教室快照信息
 * @author Administrator
 *
 */
public class ClassroomSnap implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6311956466209493178L;
	private String classroomid;		//教室id 主键
	private String classroomname;	//教室名字
	private String classroomtype;	//教室类型
	private Integer state;			//状态;
	private String username;		//老师名字
	private String subclass;		//班级
	private String lessonname;		//课程名字
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
	public String getClassroomtype() {
		return classroomtype;
	}
	public void setClassroomtype(String classroomtype) {
		this.classroomtype = classroomtype;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSubclass() {
		return subclass;
	}
	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}
	public String getLessonname() {
		return lessonname;
	}
	public void setLessonname(String lessonname) {
		this.lessonname = lessonname;
	}
	public ClassroomSnap(String classroomid, String classroomname, String classroomtype, Integer state, String username,
			String subclass, String lessonname) {
		super();
		this.classroomid = classroomid;
		this.classroomname = classroomname;
		this.classroomtype = classroomtype;
		this.state = state;
		this.username = username;
		this.subclass = subclass;
		this.lessonname = lessonname;
	}
	public ClassroomSnap() {
		super();
	}
	@Override
	public String toString() {
		return "ClassroomSnap [classroomid=" + classroomid + ", classroomname=" + classroomname + ", classroomtype="
				+ classroomtype + ", state=" + state + ", username=" + username + ", subclass=" + subclass
				+ ", lessonname=" + lessonname + "]";
	}
	
	
}
