package com.example.smart.dao;

import com.example.smart.entity.Answer;
import com.example.smart.entity.AnswerDetail;
import com.example.smart.entity.Subject;

import java.util.List;



public interface SubjectDao {
	public int insertSubject(Subject subject);
	public List<Integer> selectSubjectsInOnePPT(int pptid);
	public Subject selectOneSubject(int pptid, int pptpage);
	public Subject selectOneSubjectById(int subjectid);
	public int insertIntoAnswers(int subjectid, int attendclassid, int unanswercount);
	
	public int insertIntoAnswerDetail(int subjectid, int attendclassid, String userid, String useranswer, int score, int ifsure);
	public int updateAnswers(int subjectid, int attendclassid, int change1, int change2, int change3);
	public Answer selectOneAnswer(int subjectid, int attendclassid);
	
	public List<Answer> selectAnswers(int attendclassid);
	
	public AnswerDetail selectAnswerDetail(int subjectid, int attendclassid, String userid);
	
	
	public List<AnswerDetail> selectAnswerDetails(int subjectid, int attendclassid);
	public int endAnswering(int subjectid, int attendclassid);
}
