package com.example.smart.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import net.common.util.MQUtil;
import net.smartschool.dao.AttendClassDao;
import net.smartschool.dao.SubjectDao;
import net.smartschool.dao.TickupDao;
import net.smartschool.dao.TimeDao;
import net.smartschool.entity.Answer;
import net.smartschool.entity.AnswerDetail;
import net.smartschool.entity.AttendClass;
import net.smartschool.entity.Subject;
import net.smartschool.entity.XNXQHAndZC;
import net.smartschool.impl.AttendClassDaoImp;
import net.smartschool.impl.SubjectDaoImpl;
import net.smartschool.impl.TickupDaoImp;
import net.smartschool.impl.TimeDaoImpl;

public class SubjectService {
	SubjectDao dao = new SubjectDaoImpl();
	private static final Logger logger = LogManager.getLogger();
	public String insertSubject(Subject subject) {
		JSONObject res = new JSONObject();
		try {
			int count = 0;
			count = dao.insertSubject(subject);
			if (count > 0) {
				res.put("state", 0);
				res.put("msg", "添加题目信息成功！");
			} else {
				res.put("state", 100);
				res.put("msg", "添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String sendSubject(int pptid, int pptpage, int attendclassid) {
		JSONObject res = new JSONObject();
		JSONObject resMQ = new JSONObject();
		AttendClassDao attendClassDao = new AttendClassDaoImp();
		TimeDao timeDao = new TimeDaoImpl();
		TickupDao tickupDao = new TickupDaoImp();
		try {
			Subject subject = dao.selectOneSubject(pptid, pptpage);
			int subjectid = subject.getSubjectid();
			XNXQHAndZC xnxqhAndZC = timeDao.selectXNXQHAndZC();
			int zc = xnxqhAndZC.getZc();
			AttendClass attendClass = attendClassDao.selectAttendClass(attendclassid);
			long curriculumid = attendClass.getCurriculumid();
			int unanswercount = tickupDao.selectTickCountByScanning(curriculumid, zc);
			int count = dao.insertIntoAnswers(subjectid, attendclassid, unanswercount);
			if (count > 0) {
				res.put("state", 0);
				res.put("msg", "推送题目正常！");
			} else {
				res.put("state", 100);
				res.put("msg", "插入答题记录表失败！");
			}
			resMQ.put("state", 0);
			resMQ.put("msg", "发送正常！");
			resMQ.put("subjecttype", subject.getSubjecttype());
			resMQ.put("subjectcontent", subject.getSubjectcontent());
			resMQ.put("option", subject.getOption());
			resMQ.put("score", subject.getScore());
			MQUtil.sendToMQ("sendSubject", Integer.toString(attendclassid), "c", resMQ.toString());
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String studentAnswering(int subjectid, int attendclassid, String userid, String useranswer) {
		JSONObject res = new JSONObject();
		try {
			Subject subject = dao.selectOneSubjectById(subjectid);
			String answer = subject.getAnswer();
			int iscorrect;
			int score;
			if (useranswer.equals(answer)) {
				iscorrect = 0;
				score = subject.getScore();
				dao.updateAnswers(subjectid, attendclassid, 1, -1, 1);
			} else {
				iscorrect = 1;
				score = 0;
				dao.updateAnswers(subjectid, attendclassid, 1, -1, -1);
			}
			int count = dao.insertIntoAnswerDetail(subjectid, attendclassid, userid, useranswer, score, iscorrect);
			
			if (count > 0) {
				res.put("state", 0);
				res.put("msg", "正常！");
				res.put("iscorrect", iscorrect);
			} else {
				res.put("state", 100);
				res.put("msg", "插入答题记录表失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String selectOneAnswer(int subjectid, int attendclassid) {
		JSONObject res = new JSONObject();
		try {
			Answer answer = new Answer();
			answer = dao.selectOneAnswer(subjectid, attendclassid);
			if (answer != null) {
				res.put("state", 0);
				res.put("msg", "查询单个答题记录成功！");
				res.put("data", answer);
			} else {
				res.put("state", 100);
				res.put("msg", "查询失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String selectAnswers(int attendclassid) {
		JSONObject res = new JSONObject();
		try {
			List<Answer> list = new ArrayList<>();
			list = dao.selectAnswers(attendclassid);
			if (list != null) {
				res.put("state", 0);
				res.put("msg", "答题记录查询成功！");
				res.put("data", list);
			} else {
				res.put("state", 100);
				res.put("msg", "答题记录查询失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String selectAnswerDetail(int subjectid, int attendclassid, String userid) {
		JSONObject res = new JSONObject();
		try {
			AnswerDetail answerDetail = dao.selectAnswerDetail(subjectid, attendclassid, userid);
			if (answerDetail != null) {
				res.put("state", 0);
				res.put("msg", "查询答题详情成功！");
				res.put("data", answerDetail);
			} else {
				res.put("state", 100);
				res.put("msg", "查询答题详情失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String raceRanking(int subjectid, int attendclassid) {
		JSONObject res = new JSONObject();
		try {
			Answer answer = new Answer();
			answer = dao.selectOneAnswer(subjectid, attendclassid);
			List<AnswerDetail> list = dao.selectAnswerDetails(subjectid, attendclassid);
			Date starttime = answer.getStartanswertime();
			Date spendtime;
			AnswerDetail answerDetail;
			for (int i = 0 ; i < list.size(); i ++) {
				answerDetail = list.get(i);
				spendtime = new Date(answerDetail.getStarttime().getTime() - starttime.getTime());
				answerDetail.setSpendtime(spendtime);
			}
			if (list.size() > 0) {
				res.put("state", 0);
				res.put("msg", "添加题目信息成功！");
				res.put("data", list);
			} else {
				res.put("state", 100);
				res.put("msg", "添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String endAnswering(int subjectid, int attendclassid) {
		JSONObject res = new JSONObject();
		JSONObject resMQ = new JSONObject();
		try {
//			Subject subject = dao.selectOneSubject(pptid, pptpage);
			Subject subject = dao.selectOneSubjectById(subjectid);
			int count = 0;
//			int subjectid = subject.getSubjectid();
			count = dao.endAnswering(subjectid, attendclassid);
			if (count > 0) {
				res.put("state", 0);
				res.put("msg", "结束答题成功！");
			} else {
				res.put("state", 100);
				res.put("msg", "结束答题失败！");
			}
			String solution = subject.getResolution();
			resMQ.put("state", 0);
			resMQ.put("msg", "发送正常");
			resMQ.put("solution", solution);
			MQUtil.sendToMQ("endAnswering", Integer.toString(attendclassid), "c", resMQ.toString());
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}

}
