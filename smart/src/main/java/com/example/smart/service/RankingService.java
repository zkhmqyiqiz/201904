package com.example.smart.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import net.common.util.FtpUtils;
import net.smartschool.dao.RankingDao;
import net.smartschool.entity.Lessonuse;
import net.smartschool.entity.Ranking;
import net.smartschool.entity.TeamWeekFestivals;
import net.smartschool.entity.Tickup;
import net.smartschool.impl.LessonuseDaoImp;
import net.smartschool.impl.RankingDaoImp;

public class RankingService {
	RankingDao dao = new RankingDaoImp();
	private static final Logger logger = LogManager.getLogger();
	public String selectGoodRanking(String userid, String lessonid) {
		JSONObject res = new JSONObject();
		Integer count = null;
		Float judge = null;
		try {
			count = Integer.parseInt(FtpUtils.getProperties("jdbc.properties", "checkingPeopleNumber"));
			judge = Float.parseFloat(FtpUtils.getProperties("jdbc.properties", "judge"));
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", 100);
			res.put("msg", "查询配置文件失败！");
		}
		
		try {
			List<Ranking> tt = dao.selectGoodRanking(userid, lessonid,count);
			List<Ranking> t = new ArrayList<>();
			for (int i = 0; i < tt.size(); i ++) {
				Ranking ranking = tt.get(i);
				if (ranking.getAttendance() < judge) {
					break;
				}
				t.add(tt.get(i));
			}
			if (t.size() > 0) {
				res.put("state", 0);
				res.put("msg", "查询好学生排行榜成功！");
				res.put("data", t);
			} else {
				res.put("state", 100);
				res.put("msg", "查询好学生排行榜失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
		
	}
	public String selectBadRanking(String userid, String lessonid) {
		JSONObject res = new JSONObject();
		Integer count = null;
		Float judge = null;
		try {
			count = Integer.parseInt(FtpUtils.getProperties("jdbc.properties", "checkingPeopleNumber"));
			judge = Float.parseFloat(FtpUtils.getProperties("jdbc.properties", "judge"));
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", 100);
			res.put("msg", "读取配置文件失败！");
		}
		
		try {
			List<Ranking> tt = dao.selectBadRanking(userid, lessonid, count);
			List<Ranking> t = new ArrayList<>();
			for (int i = 0; i < tt.size(); i ++) {
				Ranking ranking = tt.get(i);
				if (ranking.getAttendance() > judge) {
					break;
				}
				t.add(tt.get(i));
			}
			if (t.size() > 0) {
				res.put("state", 0);
				res.put("msg", "查询好学生排行榜成功！");
				res.put("data", t);
			} else {
				res.put("state", 100);
				res.put("msg", "查询好学生排行榜失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
		
	}
	
	//插入学生考勤的相关信息
			public String InsertStudentCheck(int page, int count) {
				System.out.println("InsertStudentCheck数据插入开始");
				JSONObject res =new JSONObject();
				int successCount = 0 ;//插入成功多少条数据
				int errorCount = 0 ;//插入失败多少条数据
				long l1 = System.currentTimeMillis();
				try {
					LessonuseDaoImp lessonusedaoimp = new LessonuseDaoImp();
					TeamWeekFestivals teamweekfestivals = lessonusedaoimp.selectWeekCourseZC();
					if(teamweekfestivals==null) {
						res.put("state", 0);
						res.put("msg", "数据库没有数据！");
						return res.toString();
					}
					String xnxqh = teamweekfestivals.getXnxqh();//学年学期号
					Integer zc = teamweekfestivals.getZc();//周次
					Integer week = teamweekfestivals.getXqmc();//星期几
					/*String xnxqh = "2018-2019-1";//学年学期号
					Integer zc = 19;//周次
					Integer week = 1;//星期几
*/					List <Lessonuse> listTodayToStudentAndLesson =  dao.selectTodayToStudentAndLesson(xnxqh, week, zc);
					List <Lessonuse> listTodayCurriculumid =  dao.selectTodayCurriculumid(xnxqh, week, zc);
					List <Tickup> listTickUpAllStatus = dao.selectTickUpAllStatus(xnxqh, week, zc);
					String userid = null;//学生ID
					String teacherid = null;//老师ID
					Integer lessonid = 0;
					Integer lessoncount = 0 ;//每个学生此时应该上的课程节次总数
					Integer latecount = 0 ;//每个学生每门课迟到节次总数
					Integer tickupcount = 0 ;//每个学生每门课迟到节次总数
					if(listTodayToStudentAndLesson.size() > 0) {
						for (int i = 0; i < listTodayToStudentAndLesson.size(); i++) {
							lessonid = listTodayToStudentAndLesson.get(i).getLessonid();
							userid =  listTodayToStudentAndLesson.get(i).getUserid();
							for (int j = 0; j < listTodayCurriculumid.size(); j++) {
								Integer lessonid2 = listTodayCurriculumid.get(j).getLessonid();
								String userid2 = listTodayCurriculumid.get(j).getUserid();
								Long curriculumid = listTodayCurriculumid.get(j).getCurriculumid();
								if((lessonid2.equals(lessonid))&&(userid2.equals(userid))) {
									teacherid = listTodayCurriculumid.get(j).getTeacherid();
									if(zc > listTodayCurriculumid.get(j).getWeekend()) {//如若zc>weekend
										lessoncount = lessoncount + listTodayCurriculumid.get(j).getWeekend()+1-listTodayCurriculumid.get(j).getWeekstart();
									}else if((zc <= listTodayCurriculumid.get(j).getWeekend())&&(zc >= listTodayCurriculumid.get(j).getWeekstart()) ){//如若zc>=weekstart and zc<=weekend
										lessoncount = lessoncount + zc+1-listTodayCurriculumid.get(j).getWeekstart();
									}else {//如若zc<weekstart ,数据没有变化
										
									}
									for (int k = 0; k < listTickUpAllStatus.size(); k++) {
										Long curriculumids = listTickUpAllStatus.get(k).getCurriculumid();
										String TickupUserid = listTickUpAllStatus.get(k).getUserid();
										if((curriculumids.equals(curriculumid))&&(TickupUserid.equals(userid2))) {
											if(listTickUpAllStatus.get(k).getSuccess()==1) {
												latecount = latecount +1;//累加某学生的某门课的迟到总次数
												tickupcount = tickupcount + 1;
											}else {
												tickupcount = tickupcount + 1 ;
											}
										}
									}
								}
								
							}
							if(latecount==1) {
								System.out.println(11);
							}
							Integer alreadyclass = lessoncount;
							Integer numbers = tickupcount;
							Float attendance = (float) numbers/alreadyclass;
							Integer absence = alreadyclass - numbers;
							Integer late = latecount;
							dao.insertStudentCheck(userid, lessonid, xnxqh, teacherid, alreadyclass, late, attendance, absence);
							successCount++;
							lessoncount = 0;
							tickupcount= 0 ;
							latecount = 0 ;
						}
					}
					
					res.put("state", 0);
					
				} catch (Exception e) {
					e.printStackTrace();
					errorCount++;
					res.put("state", -500);
					res.put("msg", "数据库错误！");
					logger.info("RankingService层中selectStudentCheck出错");
				}
				System.out.println("数据插入结束");
				logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
				long l2 = System.currentTimeMillis();
				System.out.println("学生考勤统计表更新或插入数据数据耗时："+(l2-l1));
				System.out.println("插入或更新成功"+successCount+"条，失败"+errorCount+"条");
				return res.toString();
				
			}
	/*//插入学生考勤的相关信息
		public String InsertStudentCheck(int page, int count) {
			System.out.println("InsertStudentCheck数据插入开始");
			JSONObject res =new JSONObject();
			try {
				LessonuseDaoImp lessonusedaoimp = new LessonuseDaoImp();
				TeamWeekFestivals teamweekfestivals = lessonusedaoimp.selectWeekCourseZC();
				String xnxqh = teamweekfestivals.getXnxqh();
				Integer zc = teamweekfestivals.getZc();
				int a = dao.selectTStudentCheckCount(xnxqh);
				if(a > 0) {
					int b = a / count;//设置分割的次数
					int c = a % count; //取余
					if(b == 0) {
						new Thread(new StudentCheckData(page, count, xnxqh, zc)).start();
					}else if((b==1)&&(c==0)){
						new Thread(new StudentCheckData(page, count, xnxqh, zc)).start();
					}else {
						int d = 0;
						if(c > 0 ) {
							d= b+1;
						}else {
							d = b;
						}
						for (int i = 0; i < d; i++) {//采用多线程的方式，分段式查询和插入
							new Thread(new StudentCheckData(page, count, xnxqh, zc)).start();
							page++;
						}
					}
				}
				res.put("state", 0);
				
			} catch (Exception e) {
				e.printStackTrace();
				res.put("state", -500);
				res.put("msg", "数据库错误！");
				logger.info("RankingService层中selectStudentCheck出错");
			}
			System.out.println("数据插入结束");
			logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
			return res.toString();
			
		}*/
		
/*	//插入学生考勤的相关信息
	public String selectStudentCheck(int page, int count) {
		JSONObject res =new JSONObject();
		try {
			LessonuseDaoImp lessonusedaoimp = new LessonuseDaoImp();
			TeamWeekFestivals teamweekfestivals = lessonusedaoimp.selectWeekCourseZC();
			String xnxqh = teamweekfestivals.getXnxqh();
			//根据学年学期号查询课程ID和学生ID
			List<Lessonuse> listTStudentCheck = dao.selectTStudentCheck(xnxqh,page,count);
			int zc = teamweekfestivals.getZc();
			System.out.println("数据插入开始");
			if(listTStudentCheck.size() > 0) {
				for (int i = 0; i < listTStudentCheck.size(); i++) {
					String userid = listTStudentCheck.get(i).getUserid();
					Integer lessonid = listTStudentCheck.get(i).getLessonid();
					Long curriculumid = listTStudentCheck.get(i).getcurriculumid();
					
					List<Lessonuse> listLessonuseStudentCheck = dao.selectLessonuseStudentCheck(lessonid, userid);
					String teacherid = null;
					Integer alreadyclass = 0;
					Integer late = 0;
					Integer numbers = 0;//总共签到次数
					for (int j = 0; j < listLessonuseStudentCheck.size(); j++) {
						Lessonuse lessonuse = listLessonuseStudentCheck.get(i);
						teacherid = lessonuse.getUserid();//得到老师的编号
						int a = 0;//每一节课已经上了多少次
						if(lessonuse.getWeekend() <= zc) {
							a = lessonuse.getWeekend();
						}else {
							a = zc+1-lessonuse.getWeekstart();
						}
						alreadyclass = alreadyclass + a;
						List<Tickup> listTickup = dao.selectTickupStudentCheck(userid, curriculumid);
						int b = listTickup.size();//每一节课的签到总次数
						int c = 0;//每一节课迟到的总次数
						for (int k = 0; k < listTickup.size(); k++) {
							if(listTickup.get(i).getSuccess()==1) {
								c++;
							}
						}
						late = late + c;
						numbers = numbers + b;
					}
					Float attendance = (float) (numbers/alreadyclass);
					Integer absence = alreadyclass - numbers;
					dao.insertStudentCheck(userid, lessonid, xnxqh, teacherid, alreadyclass, late, attendance, absence);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("RankingService层中selectStudentCheck出错");
		}
		System.out.println("数据插入结束");
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
		
	}*/
}
