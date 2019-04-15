package com.example.smart.entity;

import java.io.Serializable;

/**
 * 刷卡信息
 * @author Administrator
 *
 */
public class Cardposition implements Serializable {
	private static final long serialVersionUID = -3125249877143169120L;
	private int cpozitionId; //刷卡机id
	private String cpozitionName;//刷卡机名字
	private String cpozitionAt;//刷卡进位置
	private String company;//公司名
	public int getCpozitionId() {
		return cpozitionId;
	}
	public void setCpozitionId(int cpozitionId) {
		this.cpozitionId = cpozitionId;
	}
	public String getCpozitionName() {
		return cpozitionName;
	}
	public void setCpozitionName(String cpozitionName) {
		this.cpozitionName = cpozitionName;
	}
	public String getCpozitionAt() {
		return cpozitionAt;
	}
	public void setCpozitionAt(String cpozitionAt) {
		this.cpozitionAt = cpozitionAt;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Cardposition [cpozitionId=" + cpozitionId + ", cpozitionName=" + cpozitionName + ", cpozitionAt="
				+ cpozitionAt + ", company=" + company + "]";
	}
	public Cardposition() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cardposition(int cpozitionId, String cpozitionName, String cpozitionAt, String company) {
		super();
		this.cpozitionId = cpozitionId;
		this.cpozitionName = cpozitionName;
		this.cpozitionAt = cpozitionAt;
		this.company = company;
	}
	
}
