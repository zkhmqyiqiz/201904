package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

public class Carduse implements Serializable{
	private static final long serialVersionUID = 5538160698156233316L;
	private Long cardid;
	private Integer cpozitionid;
	private Date time;
	private String company;
	private String cpozitionname;
	private String cpozitionat;
	
	public Long getCardid() {
		return cardid;
	}
	public void setCardid(Long cardid) {
		this.cardid = cardid;
	}
	public Integer getCpozitionid() {
		return cpozitionid;
	}
	public void setCpozitionid(Integer cpozitionid) {
		this.cpozitionid = cpozitionid;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
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
	public String getCpozitionat() {
		return cpozitionat;
	}
	public void setCpozitionat(String cpozitionat) {
		this.cpozitionat = cpozitionat;
	}
	
	
}
