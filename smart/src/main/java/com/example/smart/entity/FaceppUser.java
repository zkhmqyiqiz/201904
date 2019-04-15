package com.example.smart.entity;

import java.io.Serializable;

public class FaceppUser implements Serializable{
	private static final long serialVersionUID = -8606996337320948883L;
	String ip;
	String username;
	String password;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public FaceppUser(String ip, String username, String password) {
		super();
		this.ip = ip;
		this.username = username;
		this.password = password;
	}
	public FaceppUser() {
		super();
	}
	@Override
	public String toString() {
		return "FaceppUser [ip=" + ip + ", username=" + username + ", password=" + password + "]";
	}
	
}
