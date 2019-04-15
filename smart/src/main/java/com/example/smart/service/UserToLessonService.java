package com.example.smart.service;


import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;

import net.smartmiddle.tcpserver.MinaServerHandler;
import net.smartschool.dao.UserToLessonDao;
import net.smartschool.entity.Lessonuse;
import net.smartschool.entity.SignInLog;
import net.smartschool.impl.UserToLessonDaoImp;

public class UserToLessonService {
	UserToLessonDao dao = new UserToLessonDaoImp();
	public static final Base64.Encoder ENCODER = Base64.getEncoder();
	public static final String WARNPIC = "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";
	private final static Log logger = LogFactory.getLog(MinaServerHandler.class);
	
	//查询所有学生信息
	public String selectUserToLessonNotTickup(Long curriculumid) {
		JSONObject res = new JSONObject();
		List<SignInLog> signInLogListNotTickUp = null;
		//List<SignInLog> signInLogList= new ArrayList<SignInLog>();
		try {
			signInLogListNotTickUp = dao.selectUserToLessonNotTickup(curriculumid);
			logger.info("所有人员的长度："+signInLogListNotTickUp.size());
			if (signInLogListNotTickUp.size()>0&&signInLogListNotTickUp != null) {
				for(int i=0;i<signInLogListNotTickUp.size();i++){
					SignInLog signInLog = signInLogListNotTickUp.get(i);//获取每一个SignInLog对象
			        String name ;
			        if(signInLog.getPhoto()!=null) {
				        name= ENCODER.encodeToString(signInLog.getPhoto());
				        signInLogListNotTickUp.get(i).setnPhoto(name);
				      //  logger.info("已经签到信息："+l.get(i).toString());
			        }
			    }
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", signInLogListNotTickUp);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			res.put("state", -500);
			res.put("msg", "数据库错误selectUserToLessonNotTickup！");
		}
		
		return res.toString();
		
	}
	
	
	//查询已经签到的学生信息
	public String selectUserToLesson(Long curriculumid) {
		JSONObject res = new JSONObject();
		List<SignInLog> signInLogListTickUp = null;
		//List<SignInLog> signInLogList= new ArrayList<SignInLog>();
		try {
			signInLogListTickUp = dao.selectUserToLesson(curriculumid);
			logger.info("已经签到的人员长度："+signInLogListTickUp.size());
			if (signInLogListTickUp.size()>0&&signInLogListTickUp != null) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", signInLogListTickUp);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			res.put("state", -500);
			res.put("msg", "数据库错误selectUserToLesson！");
		}
		
		return res.toString();
		
	}
		
		
	//查询当前课程信息
	public String selectSignLesson(String IP) {
		JSONObject res = new JSONObject();
		Lessonuse lessonuse = null;
		try {
			lessonuse = dao.selectSignLesson(IP);
			logger.info("selectSignUser方法正常执行！");
			if (lessonuse != null) {
				lessonuse.setLessonuseid(lessonuse.getCurriculumid());
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", lessonuse);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			res.put("state", -500);
			res.put("msg", "数据库错误selectSignUser！");
		}
		
		return res.toString();
		
	}
	
	//查询当前课程中该学生是否存在
	public String selectTickupStudent(Long curriculumid, String userid) {
		JSONObject res = new JSONObject();
		SignInLog signinlog = null;
		try {
			signinlog = dao.selectTickupStudent(curriculumid, userid);
			logger.info("selectSignUser方法正常执行！");
			if (signinlog != null) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", signinlog);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			res.put("state", -500);
			res.put("msg", "数据库错误selectTickupStudent！");
			logger.info("数据库错误selectTickupStudent！");
		}
		
		return res.toString();
		
	}
	
	
	/*public String selectUserToLesson(String IP) {
		JSONObject res = new JSONObject();
		List<SignInLog> signInLogListTickUp = null;
		List<SignInLog> signInLogListNotTickUp = null;
		//List<SignInLog> signInLogList= new ArrayList<SignInLog>();
		try {
			signInLogListTickUp = dao.selectUserToLesson(IP);
			signInLogListNotTickUp = dao.selectUserToLessonNotTickup(IP);
			logger.info("所有人员的长度："+signInLogListNotTickUp.size());
			logger.info("已经签到人员的长度："+signInLogListTickUp.size());
			for (int i = 0; i < signInLogListNotTickUp.size(); i++) {
				signInLogListNotTickUp.get(i).setSuccess(1);
				for (int j = 0; j < signInLogListTickUp.size(); j++) {
					String sTickup=signInLogListTickUp.get(j).getUserId();
					String sNotTickup=signInLogListNotTickUp.get(i).getUserId();
					if(sTickup.equals(sNotTickup)) {
						//signInLogList.add(signInLogListTickUp.get(j));
						signInLogListNotTickUp.get(i).setSuccess(0);
						logger.info("已经签到信息："+signInLogListNotTickUp.get(i).toString());
					}
				}
			}
			//logger.info("已经签到信息显示完毕");
			List<SignInLog> l = new LinkedList<>();
			List<String> s = new LinkedList<>();
			signInLogListNotTickUp.stream().forEach((one)->{
				if(!s.contains(one.getUserId())) {
					l.add(one);
					s.add(one.getUserId());
				}
			});
			if (l.size()>0&&l != null) {
				for(int i=0;i<l.size();i++){
					SignInLog signInLog = l.get(i);//获取每一个SignInLog对象
			        String name ;
			        if(signInLog.getPhoto()!=null) {
				        name= ENCODER.encodeToString(signInLog.getPhoto());
				        l.get(i).setnPhoto(name);
				      //  logger.info("已经签到信息："+l.get(i).toString());
			        }
			    }
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", l);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			res.put("state", -500);
			res.put("msg", "数据库错误userToLesson！");
		}
		
		
		return res.toString();
		
	}*/
	
	/**
	 * @author ZHANKUN
	 * @Vsersion 2019-03-07*/
	//根据教室id查询当前课程信息
	public String selectSignLessonbyClassroomid(String classroomid) {
		JSONObject res = new JSONObject();
		Lessonuse lessonuse = null;
		try {
			lessonuse = dao.selectSignLesson(classroomid);
			logger.info("selectSignUser方法正常执行！");
			if (lessonuse != null) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", lessonuse);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			res.put("state", -500);
			res.put("msg", "数据库错误selectSignUser！");
		}
		
		return res.toString();
		
	}
	
	/**
	 * @author ZHANKUN
	 * @Vsersion 2019-03-07*/
	//根据教室id查询当前课程所有已经签到的学生的信息
	public String selectFaceByClassroomid(String classroomid) {
		JSONObject res = new JSONObject();
		Lessonuse lessonuse = null;
		List<SignInLog> signInLogListTickUp = null;
		try {
			lessonuse = dao.selectSignLessonbyClassroomids(classroomid);//1.查询当前课堂id（Curriculumid）
			if(lessonuse != null) {
				signInLogListTickUp = dao.selectUserToLesson(lessonuse.getCurriculumid());//2.根据Curriculumid查询当前课程中所有已经签到的学生信息
				if (signInLogListTickUp.size()>0&&signInLogListTickUp != null) {
					res.put("state", 0);
					res.put("msg", "查询配置成功！");
					res.put("data", signInLogListTickUp);
				} else {
					res.put("state", 100);
					res.put("msg", "查询配置失败！");
				}
			}else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误selectUserToLesson！");
		}
		return res.toString();
		
	}
	
	/**
	 * @author ZHANKUN
	 * @Vsersion 2019-03-07
	 * 功能描述：通过classroomid、type、time、lessonjc查询某天某个教室某节课所有签到的学生*/
	
	public String selectFaceByDay(String classroomid,int type,Date time,int lessonjc) {
		JSONObject res = new JSONObject();
		Lessonuse lessonuse = null;
		List<SignInLog> list = null;
		try {
			lessonuse = dao.selecthSignLesson(classroomid, time, lessonjc);//1.查询课堂id（Curriculumid）
			if(lessonuse != null) {
				list = dao.selecthUserToLesson(lessonuse.getCurriculumid(), time);//2.根据Curriculumid查询课程中所有已经签到的学生信息
				if (list.size()>0&&list != null) {
					res.put("state", 0);
					res.put("msg", "查询配置成功！");
					res.put("data", list);
				} else {
					res.put("state", 100);
					res.put("msg", "查询配置失败！");
				}
			}else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误selectUserToLesson！");
		}
		return res.toString();
		
	}

}
