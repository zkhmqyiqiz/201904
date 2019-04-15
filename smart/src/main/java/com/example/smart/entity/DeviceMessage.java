package com.example.smart.entity;

import java.io.Serializable;

public class DeviceMessage implements Serializable{
	private static final long serialVersionUID = 2940114999052704932L;
	private String brand;
	private String model;
	private String tung;
	private String floor;
	private String classroomname;
	private String position;
	private String status;
	private String repair;
	private String devicetype;
	private String teg;
	public DeviceMessage(String brand, String model, String tung, String floor, String classroomname, String position,
			String status, String repair, String devicetype, String teg) {
		super();
		this.brand = brand;
		this.model = model;
		this.tung = tung;
		this.floor = floor;
		this.classroomname = classroomname;
		this.position = position;
		this.status = status;
		this.repair = repair;
		this.devicetype = devicetype;
		this.teg = teg;
	}
	public DeviceMessage() {
		super();
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTung() {
		return tung;
	}
	public void setTung(String tung) {
		this.tung = tung;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getClassroomname() {
		return classroomname;
	}
	public void setClassroomname(String classroomname) {
		this.classroomname = classroomname;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRepair() {
		return repair;
	}
	public void setRepair(String repair) {
		this.repair = repair;
	}
	public String getDevicetype() {
		return devicetype;
	}
	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
	}
	public String getTeg() {
		return teg;
	}
	public void setTeg(String teg) {
		this.teg = teg;
	}
	@Override
	public String toString() {
		return "DeviceMessage [brand=" + brand + ", model=" + model + ", tung=" + tung + ", floor=" + floor
				+ ", classroomname=" + classroomname + ", position=" + position + ", status=" + status + ", repair="
				+ repair + ", devicetype=" + devicetype + ", teg=" + teg + "]";
	}
	
}
