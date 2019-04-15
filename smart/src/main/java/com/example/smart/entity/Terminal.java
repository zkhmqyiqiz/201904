package com.example.smart.entity;

import java.util.Date;

/** 
* @author 作者 E-mail: 
* @version 创建时间：2019年4月9日 下午2:07:34 
* 类说明 
*/
public class Terminal {
	private String Id;//
	private String Volume_Mute;//
	private Date LogTime;//
	private Boolean IsConnected;
	private String HexCode;//
	private String Name;//
	private String System_Changed;//
	private String Door_Control;//
	
	private Boolean success;
	private String TerminalId;
	private Boolean AC_Relay1;
	private Boolean Lock_Status;
	private Boolean Lock_ACT;
	private Boolean Computer_Status;
	private Boolean System;
	private Boolean Projector;
	private String Projection_Screen;
	private String Computer_Signal;
	private String Projection_Signal;
	private Boolean Volume;
	private String Computer_Control;
	private String Opereate_Last;
	private Boolean LAN1;
	private Boolean LAN2;
	private Boolean LAN3;
	private Boolean LAN4;
	private Boolean Alarm_Control;
	private Boolean DC_Relay2;
	private Boolean Door_Status;
	private Boolean OC1;
	private Boolean Alarm_In1;
	private Boolean Alarm_In2;
	private Boolean FPD;
	private Boolean Record;
	private Boolean Curtain;
	private Boolean Lamp;
	private Boolean Large_Screen;
	private Boolean AirConditioner;
	private String Temperature;
	private String Humidity;
	private String Voltage;
	private String PowerRate;
	private String IN_STATUS1;
	private String IN_STATUS2;
	private String IN_STATUS3;
	private String now;
	
	
	
	public Terminal(String id, String volume_Mute, Date logTime, Boolean isConnected, String hexCode, String name,
			String system_Changed, String door_Control, Boolean success, String terminalId, Boolean aC_Relay1,
			Boolean lock_Status, Boolean lock_ACT, Boolean computer_Status, Boolean system, Boolean projector,
			String projection_Screen, String computer_Signal, String projection_Signal, Boolean volume,
			String computer_Control, String opereate_Last, Boolean lAN1, Boolean lAN2, Boolean lAN3, Boolean lAN4,
			Boolean alarm_Control, Boolean dC_Relay2, Boolean door_Status, Boolean oC1, Boolean alarm_In1,
			Boolean alarm_In2, Boolean fPD, Boolean record, Boolean curtain, Boolean lamp, Boolean large_Screen,
			Boolean airConditioner, String temperature, String humidity, String voltage, String powerRate,
			String iN_STATUS1, String iN_STATUS2, String iN_STATUS3, String now) {
		super();
		Id = id;
		Volume_Mute = volume_Mute;
		LogTime = logTime;
		IsConnected = isConnected;
		HexCode = hexCode;
		Name = name;
		System_Changed = system_Changed;
		Door_Control = door_Control;
		this.success = success;
		TerminalId = terminalId;
		AC_Relay1 = aC_Relay1;
		Lock_Status = lock_Status;
		Lock_ACT = lock_ACT;
		Computer_Status = computer_Status;
		System = system;
		Projector = projector;
		Projection_Screen = projection_Screen;
		Computer_Signal = computer_Signal;
		Projection_Signal = projection_Signal;
		Volume = volume;
		Computer_Control = computer_Control;
		Opereate_Last = opereate_Last;
		LAN1 = lAN1;
		LAN2 = lAN2;
		LAN3 = lAN3;
		LAN4 = lAN4;
		Alarm_Control = alarm_Control;
		DC_Relay2 = dC_Relay2;
		Door_Status = door_Status;
		OC1 = oC1;
		Alarm_In1 = alarm_In1;
		Alarm_In2 = alarm_In2;
		FPD = fPD;
		Record = record;
		Curtain = curtain;
		Lamp = lamp;
		Large_Screen = large_Screen;
		AirConditioner = airConditioner;
		Temperature = temperature;
		Humidity = humidity;
		Voltage = voltage;
		PowerRate = powerRate;
		IN_STATUS1 = iN_STATUS1;
		IN_STATUS2 = iN_STATUS2;
		IN_STATUS3 = iN_STATUS3;
		this.now = now;
	}
	
	
	
	public Terminal() {
		super();
		// TODO 自动生成的构造函数存根
	}



	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getTerminalId() {
		return TerminalId;
	}
	public void setTerminalId(String terminalId) {
		TerminalId = terminalId;
	}
	public Boolean getAC_Relay1() {
		return AC_Relay1;
	}
	public void setAC_Relay1(Boolean aC_Relay1) {
		AC_Relay1 = aC_Relay1;
	}
	public Boolean getLock_Status() {
		return Lock_Status;
	}
	public void setLock_Status(Boolean lock_Status) {
		Lock_Status = lock_Status;
	}
	public Boolean getLock_ACT() {
		return Lock_ACT;
	}
	public void setLock_ACT(Boolean lock_ACT) {
		Lock_ACT = lock_ACT;
	}
	public Boolean getComputer_Status() {
		return Computer_Status;
	}
	public void setComputer_Status(Boolean computer_Status) {
		Computer_Status = computer_Status;
	}
	public Boolean getSystem() {
		return System;
	}
	public void setSystem(Boolean system) {
		System = system;
	}
	public Boolean getProjector() {
		return Projector;
	}
	public void setProjector(Boolean projector) {
		Projector = projector;
	}
	public String getProjection_Screen() {
		return Projection_Screen;
	}
	public void setProjection_Screen(String projection_Screen) {
		Projection_Screen = projection_Screen;
	}
	public String getComputer_Signal() {
		return Computer_Signal;
	}
	public void setComputer_Signal(String computer_Signal) {
		Computer_Signal = computer_Signal;
	}
	public String getProjection_Signal() {
		return Projection_Signal;
	}
	public void setProjection_Signal(String projection_Signal) {
		Projection_Signal = projection_Signal;
	}
	public Boolean getVolume() {
		return Volume;
	}
	public void setVolume(Boolean volume) {
		Volume = volume;
	}
	public String getComputer_Control() {
		return Computer_Control;
	}
	public void setComputer_Control(String computer_Control) {
		Computer_Control = computer_Control;
	}
	public String getOpereate_Last() {
		return Opereate_Last;
	}
	public void setOpereate_Last(String opereate_Last) {
		Opereate_Last = opereate_Last;
	}
	public Boolean getLAN1() {
		return LAN1;
	}
	public void setLAN1(Boolean lAN1) {
		LAN1 = lAN1;
	}
	public Boolean getLAN2() {
		return LAN2;
	}
	public void setLAN2(Boolean lAN2) {
		LAN2 = lAN2;
	}
	public Boolean getLAN3() {
		return LAN3;
	}
	public void setLAN3(Boolean lAN3) {
		LAN3 = lAN3;
	}
	public Boolean getLAN4() {
		return LAN4;
	}
	public void setLAN4(Boolean lAN4) {
		LAN4 = lAN4;
	}
	public Boolean getAlarm_Control() {
		return Alarm_Control;
	}
	public void setAlarm_Control(Boolean alarm_Control) {
		Alarm_Control = alarm_Control;
	}
	public Boolean getDC_Relay2() {
		return DC_Relay2;
	}
	public void setDC_Relay2(Boolean dC_Relay2) {
		DC_Relay2 = dC_Relay2;
	}
	public Boolean getDoor_Status() {
		return Door_Status;
	}
	public void setDoor_Status(Boolean door_Status) {
		Door_Status = door_Status;
	}
	public Boolean getOC1() {
		return OC1;
	}
	public void setOC1(Boolean oC1) {
		OC1 = oC1;
	}
	public Boolean getAlarm_In1() {
		return Alarm_In1;
	}
	public void setAlarm_In1(Boolean alarm_In1) {
		Alarm_In1 = alarm_In1;
	}
	public Boolean getAlarm_In2() {
		return Alarm_In2;
	}
	public void setAlarm_In2(Boolean alarm_In2) {
		Alarm_In2 = alarm_In2;
	}
	public Boolean getFPD() {
		return FPD;
	}
	public void setFPD(Boolean fPD) {
		FPD = fPD;
	}
	public Boolean getRecord() {
		return Record;
	}
	public void setRecord(Boolean record) {
		Record = record;
	}
	public Boolean getCurtain() {
		return Curtain;
	}
	public void setCurtain(Boolean curtain) {
		Curtain = curtain;
	}
	public Boolean getLamp() {
		return Lamp;
	}
	public void setLamp(Boolean lamp) {
		Lamp = lamp;
	}
	public Boolean getLarge_Screen() {
		return Large_Screen;
	}
	public void setLarge_Screen(Boolean large_Screen) {
		Large_Screen = large_Screen;
	}
	public Boolean getAirConditioner() {
		return AirConditioner;
	}
	public void setAirConditioner(Boolean airConditioner) {
		AirConditioner = airConditioner;
	}
	public String getTemperature() {
		return Temperature;
	}
	public void setTemperature(String temperature) {
		Temperature = temperature;
	}
	public String getHumidity() {
		return Humidity;
	}
	public void setHumidity(String humidity) {
		Humidity = humidity;
	}
	public String getVoltage() {
		return Voltage;
	}
	public void setVoltage(String voltage) {
		Voltage = voltage;
	}
	public String getPowerRate() {
		return PowerRate;
	}
	public void setPowerRate(String powerRate) {
		PowerRate = powerRate;
	}
	public String getIN_STATUS1() {
		return IN_STATUS1;
	}
	public void setIN_STATUS1(String iN_STATUS1) {
		IN_STATUS1 = iN_STATUS1;
	}
	public String getIN_STATUS2() {
		return IN_STATUS2;
	}
	public void setIN_STATUS2(String iN_STATUS2) {
		IN_STATUS2 = iN_STATUS2;
	}
	public String getIN_STATUS3() {
		return IN_STATUS3;
	}
	public void setIN_STATUS3(String iN_STATUS3) {
		IN_STATUS3 = iN_STATUS3;
	}
	public String getNow() {
		return now;
	}
	public void setNow(String now) {
		this.now = now;
	}
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getVolume_Mute() {
		return Volume_Mute;
	}
	public void setVolume_Mute(String volume_Mute) {
		Volume_Mute = volume_Mute;
	}
	public Date getLogTime() {
		return LogTime;
	}
	public void setLogTime(Date logTime) {
		LogTime = logTime;
	}
	public Boolean getIsConnected() {
		return IsConnected;
	}
	public void setIsConnected(Boolean isConnected) {
		IsConnected = isConnected;
	}
	public String getHexCode() {
		return HexCode;
	}
	public void setHexCode(String hexCode) {
		HexCode = hexCode;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSystem_Changed() {
		return System_Changed;
	}
	public void setSystem_Changed(String system_Changed) {
		System_Changed = system_Changed;
	}
	public String getDoor_Control() {
		return Door_Control;
	}
	public void setDoor_Control(String door_Control) {
		Door_Control = door_Control;
	}
	@Override
	public String toString() {
		return "Terminal [Id=" + Id + ", Volume_Mute=" + Volume_Mute + ", LogTime=" + LogTime + ", IsConnected="
				+ IsConnected + ", HexCode=" + HexCode + ", Name=" + Name + ", System_Changed=" + System_Changed
				+ ", Door_Control=" + Door_Control + ", success=" + success + ", TerminalId=" + TerminalId
				+ ", AC_Relay1=" + AC_Relay1 + ", Lock_Status=" + Lock_Status + ", Lock_ACT=" + Lock_ACT
				+ ", Computer_Status=" + Computer_Status + ", System=" + System + ", Projector=" + Projector
				+ ", Projection_Screen=" + Projection_Screen + ", Computer_Signal=" + Computer_Signal
				+ ", Projection_Signal=" + Projection_Signal + ", Volume=" + Volume + ", Computer_Control="
				+ Computer_Control + ", Opereate_Last=" + Opereate_Last + ", LAN1=" + LAN1 + ", LAN2=" + LAN2
				+ ", LAN3=" + LAN3 + ", LAN4=" + LAN4 + ", Alarm_Control=" + Alarm_Control + ", DC_Relay2=" + DC_Relay2
				+ ", Door_Status=" + Door_Status + ", OC1=" + OC1 + ", Alarm_In1=" + Alarm_In1 + ", Alarm_In2="
				+ Alarm_In2 + ", FPD=" + FPD + ", Record=" + Record + ", Curtain=" + Curtain + ", Lamp=" + Lamp
				+ ", Large_Screen=" + Large_Screen + ", AirConditioner=" + AirConditioner + ", Temperature="
				+ Temperature + ", Humidity=" + Humidity + ", Voltage=" + Voltage + ", PowerRate=" + PowerRate
				+ ", IN_STATUS1=" + IN_STATUS1 + ", IN_STATUS2=" + IN_STATUS2 + ", IN_STATUS3=" + IN_STATUS3 + ", now="
				+ now + "]";
	}
	



}
