package com.example.smart.dao;


import com.example.smart.entity.Exam;
import com.example.smart.entity.LessonBatch;

public interface ExclDao {
	public int insertLesson(LessonBatch l);
	public int insertLessonNew(LessonBatch l);
	public int insertLessonuse(LessonBatch l);
	public int insertLessonuseNew(LessonBatch l);
	public int insertLessonform(LessonBatch l);
	
	public int insertExam(Exam e);
	public int insertcard(Long cardid, String userid);
	
}
