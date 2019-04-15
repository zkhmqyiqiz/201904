package com.example.smart.entity;

import java.io.Serializable;

public class Ranking implements Serializable {
	private static final long serialVersionUID = 6500989150627654968L;
	private String userid;		//学生id
	private String username;
	private Float attendance;			//出勤率
	public Ranking(String userid, String username, Float attendance) {
		this.userid = userid;
		this.username = username;
		this.attendance = attendance;
	}
	public Ranking() {
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Float getAttendance() {
		return attendance;
	}
	public void setAttendance(Float attendance) {
		this.attendance = attendance;
	}
	@Override
	public String toString() {
		return "Ranking [userid=" + userid + ", username=" + username + ", attendance=" + attendance + "]";
	}
	
	
}
