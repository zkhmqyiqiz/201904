package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

public class SignInLog implements Serializable{
	private static final long serialVersionUID = -1478785767588694069L;
	private String userId;
	private String userName;
	private byte[] photo;
	private int success;
	private Date lessonStart;
	private String nPhoto;
	public String getnPhoto() {
		return nPhoto;
	}
	public void setnPhoto(String nPhoto) {
		this.nPhoto = nPhoto;
	}
	public Date getLessonStart() {
		return lessonStart;
	}
	public void setLessonStart(Date lessonStart) {
		this.lessonStart = lessonStart;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignInLog other = (SignInLog) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SignInLog [userId=" + userId + ", userName=" + userName + ", success=" + success + ", lessonStart="
				+ lessonStart + ", nPhoto=" + nPhoto + "]";
	}
	
	
	

}
