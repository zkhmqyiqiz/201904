package com.example.smart.entity;

import java.io.Serializable;

public class UserToLesson implements Serializable {
	private static final long serialVersionUID = -9112181778959167275L;
	private int userToLessonId;// 学生与课程关联信息的ID
	private Long curriculumid;// 课程的ID
	private String userId;// 学生的ID

	public int getUserToLessonId() {
		return userToLessonId;
	}

	public void setUserToLessonId(int userToLessonId) {
		this.userToLessonId = userToLessonId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getCurriculumid() {
		return curriculumid;
	}

	public void setCurriculumid(Long curriculumid) {
		this.curriculumid = curriculumid;
	}
	

}
