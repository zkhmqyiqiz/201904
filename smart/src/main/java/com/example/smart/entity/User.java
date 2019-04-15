package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author administrator
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = -1489922403242107288L;
	private String userid;
	private String pass;
	private Integer role;
	private Integer audit;
	private byte[] photo;
	private String username;
	private String phone;
	private String email;
	private Integer sex;
	private String tag;
	private Date birth;//出生日期
	private Integer education;//学历，本科1，专科2，研究生3
	private Integer pcport;
	private String currentsid;//用户登录识别码
	private Integer online;//（IP电话）用户在线状态
	private String oncall;
	private Integer callstatus;//（IP电话）用户通话状态
	
	
	public String getCurrentsid() {
		return currentsid;
	}
	public void setCurrentsid(String currentsid) {
		this.currentsid = currentsid;
	}
	public Integer getOnline() {
		return online;
	}
	public void setOnline(Integer online) {
		this.online = online;
	}
	public Integer getCallstatus() {
		return callstatus;
	}
	public void setCallstatus(Integer callstatus) {
		this.callstatus = callstatus;
	}
	public Integer getPcport() {
		return pcport;
	}
	public void setPcport(Integer pcport) {
		this.pcport = pcport;
	}
	public String getOncall() {
		return oncall;
	}
	public void setOncall(String oncall) {
		this.oncall = oncall;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Integer getAudit() {
		return audit;
	}
	public void setAudit(Integer audit) {
		this.audit = audit;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Integer getEducation() {
		return education;
	}
	public void setEducation(Integer education) {
		this.education = education;
	}
	
	
}
