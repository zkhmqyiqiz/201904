package com.example.smart.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;

import net.common.util.ProtocolUtil;

public class Exam implements Serializable {
	private static final long serialVersionUID = 3076989785882385012L;
	public static final int LENGTH = 452;
	private int examId;// 考试表的主键ID
	private String classroomid;// 教室名称
	private String examName;// 考试名称
	private String lessonName;// 课程
	private String subClass;// 班级
	private Date timeStart;// 考试开始时间
	private Date timeEnd;// 考试结束时间
	private String classroomname;

	public String getClassroomname() {
		return classroomname;
	}

	public void setClassroomname(String classroomname) {
		this.classroomname = classroomname;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}


	public String getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getSubClass() {
		return subClass;
	}

	public void setSubClass(String subClass) {
		this.subClass = subClass;
	}

	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public byte[] tobyte() throws UnsupportedEncodingException {
		byte[] examIdByte = ProtocolUtil.intToBytes(this.examId);// 将examid转为数组存储
		byte[] classroomidByte = this.classroomid.getBytes("gbk");// 将edeviceip转为数组存储
		byte[] examNameByte = this.examName.getBytes("gbk");// 将examname转为数组存储
		byte[] lessonNameByte = this.lessonName.getBytes("gbk");// 将lessonname转为数组存储
		byte[] subClassByte = this.subClass.getBytes("gbk");// 将subclass转为数组存储

		int startTime = (int) (this.timeStart.getTime() / 1000);
		byte[] timeStartByte = ProtocolUtil.intToBytes(startTime);// 将timestart转为int类型，然后转为byte数组
		System.out.println("startTime=" + startTime + " byte=" + Arrays.toString(timeStartByte));
		int endTime = (int) (this.timeEnd.getTime() / 1000);
		byte[] timeEndByte = ProtocolUtil.intToBytes(endTime);// 将timeend转为int类型，然后转为byte数组
		System.out.println("endTime=" + endTime + " byte=" + Arrays.toString(timeEndByte));
		int copyPos = 0;
		byte[] countByte = new byte[4 + 150 + 200 + 45 + 45 + 4 + 4];// 设置数据的总的长度

		byte[] newExamIdByte = new byte[4];// newExamIdByte表示新的byte数组，examIdByte表示原始的byte数组
		System.arraycopy(examIdByte, 0, newExamIdByte, 0, examIdByte.length);
		System.arraycopy(newExamIdByte, 0, countByte, copyPos, newExamIdByte.length);
		copyPos += newExamIdByte.length;

		byte[] newEdeviceIpByte = new byte[150];
		System.arraycopy(classroomidByte, 0, newEdeviceIpByte, 0, classroomidByte.length);
		System.arraycopy(newEdeviceIpByte, 0, countByte, copyPos, newEdeviceIpByte.length);
		copyPos += newEdeviceIpByte.length;

		byte[] newExamNameByte = new byte[200];
		System.arraycopy(examNameByte, 0, newExamNameByte, 0, examNameByte.length);
		System.arraycopy(newExamNameByte, 0, countByte, copyPos, newExamNameByte.length);
		copyPos += newExamNameByte.length;

		byte[] newLessonNameByte = new byte[45];
		System.arraycopy(lessonNameByte, 0, newLessonNameByte, 0, lessonNameByte.length);
		System.arraycopy(newLessonNameByte, 0, countByte, copyPos, newLessonNameByte.length);
		copyPos += newLessonNameByte.length;

		byte[] newSubClassByte = new byte[45];
		System.arraycopy(subClassByte, 0, newSubClassByte, 0, subClassByte.length);
		System.arraycopy(newSubClassByte, 0, countByte, copyPos, newSubClassByte.length);
		copyPos += newSubClassByte.length;

		byte[] newTimeStartByte = new byte[4];
		System.arraycopy(timeStartByte, 0, newTimeStartByte, 0, timeStartByte.length);
		System.arraycopy(newTimeStartByte, 0, countByte, copyPos, newTimeStartByte.length);
		copyPos += newTimeStartByte.length;

		byte[] newTimeEndByte = new byte[4];
		System.arraycopy(timeEndByte, 0, newTimeEndByte, 0, timeEndByte.length);
		System.arraycopy(newTimeEndByte, 0, countByte, copyPos, newTimeEndByte.length);
		copyPos += newTimeEndByte.length;

		return countByte;
	}

}
