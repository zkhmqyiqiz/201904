package com.example.smart.entity;

import java.io.Serializable;

/**
 * 教室布局信息
 * @author Administrator
 *
 */
public class ClassroomLayout implements Serializable{
	private static final long serialVersionUID = 68824642736009835L;
	private String buildnumber;			//楼栋编号
	private String name;				//教室name
	private String classroomid;			//教室id
	private String mainctrip;			//主机ip
	private String inputs;				//输入视频json
	private String outputs;				//输出视频json
	private String volumelists;			//音量json
	private String modelists;			//模式控制json
	private String lightlists;			//灯光json
    private String curtainlists;		//窗帘json
    private String airconditionlists;	//空调json
	private String videoscreen;			//视频左右布局json
	public String getBuildnumber() {
		return buildnumber;
	}
	public void setBuildnumber(String buildnumber) {
		this.buildnumber = buildnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassroomid() {
		return classroomid;
	}
	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
	}
	public String getMainctrip() {
		return mainctrip;
	}
	public void setMainctrip(String mainctrip) {
		this.mainctrip = mainctrip;
	}
	public String getInputs() {
		return inputs;
	}
	public void setInputs(String inputs) {
		this.inputs = inputs;
	}
	public String getOutputs() {
		return outputs;
	}
	public void setOutputs(String outputs) {
		this.outputs = outputs;
	}
	public String getVolumelists() {
		return volumelists;
	}
	public void setVolumelists(String volumelists) {
		this.volumelists = volumelists;
	}
	public String getModelists() {
		return modelists;
	}
	public void setModelists(String modelists) {
		this.modelists = modelists;
	}
	public String getLightlists() {
		return lightlists;
	}
	public void setLightlists(String lightlists) {
		this.lightlists = lightlists;
	}
	public String getCurtainlists() {
		return curtainlists;
	}
	public void setCurtainlists(String curtainlists) {
		this.curtainlists = curtainlists;
	}
	public String getAirconditionlists() {
		return airconditionlists;
	}
	public void setAirconditionlists(String airconditionlists) {
		this.airconditionlists = airconditionlists;
	}
	public String getVideoscreen() {
		return videoscreen;
	}
	public void setVideoscreen(String videoscreen) {
		this.videoscreen = videoscreen;
	}
	@Override
	public String toString() {
		return "ClassroomLayout [buildnumber=" + buildnumber + ", name=" + name + ", classroomid=" + classroomid
				+ ", mainctrip=" + mainctrip + ", inputs=" + inputs + ", outputs=" + outputs + ", volumelists="
				+ volumelists + ", modelists=" + modelists + ", lightlists=" + lightlists + ", curtainlists="
				+ curtainlists + ", airconditionlists=" + airconditionlists + ", videoscreen=" + videoscreen + "]";
	}
	public ClassroomLayout(String buildnumber, String name, String classroomid, String mainctrip, String inputs,
			String outputs, String volumelists, String modelists, String lightlists, String curtainlists,
			String airconditionlists, String videoscreen) {
		super();
		this.buildnumber = buildnumber;
		this.name = name;
		this.classroomid = classroomid;
		this.mainctrip = mainctrip;
		this.inputs = inputs;
		this.outputs = outputs;
		this.volumelists = volumelists;
		this.modelists = modelists;
		this.lightlists = lightlists;
		this.curtainlists = curtainlists;
		this.airconditionlists = airconditionlists;
		this.videoscreen = videoscreen;
	}
	public ClassroomLayout() {
		super();
	}
	
	
	
	
}
