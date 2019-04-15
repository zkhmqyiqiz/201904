package com.example.smart.entity;

import java.io.Serializable;

/** 
* @author 作者 E-mail: 
* @version 创建时间：2018年11月23日 下午5:17:53 
* 类说明 
*/
public class DeviceerrorNew implements Serializable{
	private static final long serialVersionUID = -5194188239499745974L;
	private String deviceid;//设备ID
	private String errorname;//故障描述
	private int repair;//修复状态
	private String repairtime;//完成维修时间
	private String startrepair;//开始维修时间
	private String errortime;//报修时间
	private String repairman;//报修人
	private String userid;//报修人ID
	private String advicerepair;//报修建议
	private String scrapproposal;//设备报废建议
	private Integer repairtype;//维修方式
	private String equipmentteg;//配件备注
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
	public String getRepairtime() {
		return repairtime;
	}
	public void setRepairtime(String repairtime) {
		this.repairtime = repairtime;
	}
	public String getStartrepair() {
		return startrepair;
	}
	public void setStartrepair(String startrepair) {
		this.startrepair = startrepair;
	}
	public String getErrortime() {
		return errortime;
	}
	public void setErrortime(String errortime) {
		this.errortime = errortime;
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
	public String getAdvicerepair() {
		return advicerepair;
	}
	public void setAdvicerepair(String advicerepair) {
		this.advicerepair = advicerepair;
	}
	public String getScrapproposal() {
		return scrapproposal;
	}
	public void setScrapproposal(String scrapproposal) {
		this.scrapproposal = scrapproposal;
	}
	public Integer getRepairtype() {
		return repairtype;
	}
	public void setRepairtype(Integer repairtype) {
		this.repairtype = repairtype;
	}
	public String getEquipmentteg() {
		return equipmentteg;
	}
	public void setEquipmentteg(String equipmentteg) {
		this.equipmentteg = equipmentteg;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
