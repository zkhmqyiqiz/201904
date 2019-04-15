package com.example.smart.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/** 
* @author 作者 E-mail: 
* @version 创建时间：2019年3月20日 上午10:17:49 
* 类说明 
*/
public class AllCardByUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private Long cardid;//卡号
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
	public Integer getPcport() {
		return pcport;
	}
	public void setPcport(Integer pcport) {
		this.pcport = pcport;
	}
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
	public String getOncall() {
		return oncall;
	}
	public void setOncall(String oncall) {
		this.oncall = oncall;
	}
	public Integer getCallstatus() {
		return callstatus;
	}
	public void setCallstatus(Integer callstatus) {
		this.callstatus = callstatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getCardid() {
		return cardid;
	}
	public void setCardid(Long cardid) {
		this.cardid = cardid;
	}
	@Override
	public String toString() {
		return "AllCardByUser [userid=" + userid + ", pass=" + pass + ", role=" + role + ", audit=" + audit + ", photo="
				+ Arrays.toString(photo) + ", username=" + username + ", phone=" + phone + ", email=" + email + ", sex="
				+ sex + ", tag=" + tag + ", birth=" + birth + ", education=" + education + ", pcport=" + pcport
				+ ", currentsid=" + currentsid + ", online=" + online + ", oncall=" + oncall + ", callstatus="
				+ callstatus + ", cardid=" + cardid + "]";
	}
	
	
	

}
