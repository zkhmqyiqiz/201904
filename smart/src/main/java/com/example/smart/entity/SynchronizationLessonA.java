package com.example.smart.entity;

import java.io.Serializable;

/** 
* @author 作者 E-mail: 
* @version 创建时间：2019年3月20日 下午6:43:14 
* 类说明 
*/
public class SynchronizationLessonA implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4900550527623973297L;
	private String userid;
	private String classroomid;
	private String classroomname;
	private String username;
	private Long curriculumid;
	private String lessonname;
	private String kssj;
	private String jssj;
	private String mxrq;
	private Long cardid;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getCurriculumid() {
		return curriculumid;
	}
	public void setCurriculumid(Long curriculumid) {
		this.curriculumid = curriculumid;
	}
	public String getLessonname() {
		return lessonname;
	}
	public void setLessonname(String lessonname) {
		this.lessonname = lessonname;
	}
	public String getKssj() {
		return kssj;
	}
	public void setKssj(String kssj) {
		this.kssj = kssj;
	}
	public String getJssj() {
		return jssj;
	}
	public void setJssj(String jssj) {
		this.jssj = jssj;
	}
	public String getMxrq() {
		return mxrq;
	}
	public void setMxrq(String mxrq) {
		this.mxrq = mxrq;
	}
	public Long getCardid() {
		return cardid;
	}
	public void setCardid(Long cardid) {
		this.cardid = cardid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SynchronizationLessonA [userid=" + userid + ", classroomid=" + classroomid + ", classroomname="
				+ classroomname + ", username=" + username + ", curriculumid=" + curriculumid + ", lessonname="
				+ lessonname + ", kssj=" + kssj + ", jssj=" + jssj + ", mxrq=" + mxrq + ", cardid=" + cardid + "]";
	}
	
	
	
	

}
