package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

public class Deviceerror implements Serializable{
	private static final long serialVersionUID = -5194188239499745974L;
	private String deviceid;//设备ID
	private String errorname;//故障描述
	private int repair;//修复状态
	private Date repairtime;//完成维修时间
	private Date startrepair;//开始维修时间
	private Date errortime;//报修时间
	private String repairman;//报修人
	private String userid;//报修人ID
	private Byte[] advicerepair;//报修建议
	private Byte[] scrapproposal;//设备报废建议
	private Integer repairtype;//维修方式
	private Byte[] equipmentteg;//配件备注
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public String getErrorname() {
		return errorname;
	}
	public void setErrorname(String errorname) {
		this.errorname = errorname;
	}
	public int getRepair() {
		return repair;
	}
	public void setRepair(int repair) {
		this.repair = repair;
	}
	public Date getRepairtime() {
		return repairtime;
	}
	public void setRepairtime(Date repairtime) {
		this.repairtime = repairtime;
	}
	public Date getErrortime() {
		return errortime;
	}
	public void setErrortime(Date errortime) {
		this.errortime = errortime;
	}
	public Date getStartrepair() {
		return startrepair;
	}
	public void setStartrepair(Date startrepair) {
		this.startrepair = startrepair;
	}
	public String getRepairman() {
		return repairman;
	}
	public void setRepairman(String repairman) {
		this.repairman = repairman;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Byte[] getAdvicerepair() {
		return advicerepair;
	}
	public void setAdvicerepair(Byte[] advicerepair) {
		this.advicerepair = advicerepair;
	}
	public Byte[] getScrapproposal() {
		return scrapproposal;
	}
	public void setScrapproposal(Byte[] scrapproposal) {
		this.scrapproposal = scrapproposal;
	}
	public Integer getRepairtype() {
		return repairtype;
	}
	public void setRepairtype(Integer repairtype) {
		this.repairtype = repairtype;
	}
	public Byte[] getEquipmentteg() {
		return equipmentteg;
	}
	public void setEquipmentteg(Byte[] equipmentteg) {
		this.equipmentteg = equipmentteg;
	}
	
	
}
