package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

public class Card implements Serializable{
	private static final long serialVersionUID = 4380793087654729897L;
	private Long cardid;
	private String userid;
	private String islost;
	private Date credittime;
	
	
	public Long getCardid() {
		return cardid;
	}
	public void setCardid(Long cardid) {
		this.cardid = cardid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getIslost() {
		return islost;
	}
	public void setIslost(String islost) {
		this.islost = islost;
	}
	public Date getCredittime() {
		return credittime;
	}
	public void setCredittime(Date credittime) {
		this.credittime = credittime;
	}
}	
