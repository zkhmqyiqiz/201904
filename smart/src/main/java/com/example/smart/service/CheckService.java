package com.example.smart.service;
import java.util.List;

import com.example.smart.dao.CheckDao;
import com.example.smart.dao.LessonDao;
import com.example.smart.entity.Check;
import com.example.smart.entity.TeamWeekFestivals;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckService {
	@Autowired
	private CheckDao dao;
	@Autowired
	private LessonDao lessonDao;

	private static final Logger logger = LogManager.getLogger();
	
	public String selectCourseCheck(Long curriculumid, Integer zc) {
		JSONObject res =new JSONObject();
		try {
			Check check = null;
			check = dao.selectCourseCheck(curriculumid, zc);
			if (check != null) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", check);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			} 
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	public String selectWeekCheck(String userid,Integer page, Integer count) {
		JSONObject res =new JSONObject();
		String teamweekfestivalstest = "";
		try {
			List<Check> list = null;
			LessonuseService service = new LessonuseService();
			TeamWeekFestivals teamweekfestivals = service.selectWeekCourses();
			teamweekfestivalstest = teamweekfestivals.toString();
			list = dao.selectWeekCheck(userid, teamweekfestivals.getXnxqh(), teamweekfestivals.getZc(), (page-1)*count, count);
			int a = dao.selectWeekCheckCount(userid, teamweekfestivals.getXnxqh(), teamweekfestivals.getZc());
			if (list.size()>0) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", list);
				res.put("numbers", a);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			} 
		} catch (Exception e) {
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.error("CheckDaoImp层中selectWeekCheck或selectWeekCheckCount出错,参数teamweekfestivals："+teamweekfestivalstest.toString(),e);
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	public String selectMonthCheck(String userid,Integer page, Integer count) {
		JSONObject res =new JSONObject();
		try {
			List<Check> list = null;
			LessonuseService service = new LessonuseService();
			TeamWeekFestivals teamweekfestivals = service.selectWeekCourses();
			list = dao.selectMonthCheck(userid, teamweekfestivals.getXnxqh(), (page-1)*count, count);
			int a = dao.selectMonthCheckCount(userid, teamweekfestivals.getXnxqh());
			if (list.size()>0) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", list);
				res.put("numbers", a);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			} 
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("CheckDaoImp层中selectMonthCheck或selectMonthCheckCount出错");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	public String selectSemesterCheck(String userid,Integer page, Integer count) {
		JSONObject res =new JSONObject();
		try {
			List<Check> list = null;
			LessonuseService service = new LessonuseService();
			TeamWeekFestivals teamweekfestivals = service.selectWeekCourses();
			list = dao.selectSemesterCheck(userid, teamweekfestivals.getXnxqh(), (page-1)*count, count);
			int a = dao.selectSemesterCheckCount(userid, teamweekfestivals.getXnxqh());
			if (list.size()>0) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", list);
				res.put("numbers", a);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			} 
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("CheckDaoImp层中selectSemesterCheck或selectSemesterCheckCount出错");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	public String selectCheckStat(String userid) {
		JSONObject res =new JSONObject();
		String teamweekfestivalstest = "";
		try {
			List<Check> list = null;
			List<Check> list2 = null;
			List<Check> list3 = null;
			Integer should1 = 0;
			Integer should2 = 0;
			Integer should3 = 0;
			Integer real1 = 0;
			Integer real2 = 0;
			Integer real3 = 0;
			LessonuseService service = new LessonuseService();
			TeamWeekFestivals teamweekfestivals = service.selectWeekCourses();
			teamweekfestivalstest = teamweekfestivals.toString();
			list = dao.selectWeekCheck(userid, teamweekfestivals.getXnxqh(), teamweekfestivals.getZc(), 0, 99999);
			list2 = dao.selectMonthCheck(userid, teamweekfestivals.getXnxqh(),0, 99999);
			list3 = dao.selectSemesterCheck(userid, teamweekfestivals.getXnxqh(), 0, 99999);
			for(Check one:list) {
				should1 += one.getShouldpeople();
				real1 += one.getRealpeople();
			}
			for(Check one:list2) {
				should2 += one.getShouldpeople();
				real2 += one.getRealpeople();
			}
			for(Check one:list3) {
				should3 += one.getShouldpeople();
				real3 += one.getRealpeople();
			}
			res.put("state",0);
			res.put("msg","查询数据成功！");
			res.put("weekshould", should1);
			res.put("monthshould", should2);
			res.put("semestershould", should3);
			res.put("weekreal", real1);
			res.put("monthreal", real2);
			res.put("semesterreal", real3);
		} catch (Exception e) {
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.error("CheckDaoImp层中selectWeekCheck或selectWeekCheckCount出错,参数teamweekfestivals："+teamweekfestivalstest.toString(),e);
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	
	public String InsertCheck(int page, int count) {
		JSONObject res =new JSONObject();
		int successCount = 0;//成功数量
		int errorCount = 0;//失败数量
		long l1 = System.currentTimeMillis();
		try {
			LessonuseDaoImp lessonusedaoimp = new LessonuseDaoImp();
			TeamWeekFestivals teamweekfestivals = lessonusedaoimp.selectWeekCourseZC();
			if(teamweekfestivals==null) {
				res.put("state", 0);
				res.put("msg", "数据库没有数据！");
				return res.toString();
			}
			Integer week = teamweekfestivals.getXqmc();//星期
			String xnxqh = teamweekfestivals.getXnxqh();//学年学期号
			Integer zc = teamweekfestivals.getZc();//周次
			int a = dao.selectbatchInsertCheckCount(week, xnxqh, zc);
			System.out.println("数据插入开始");
			List<Check> list = null;
			list = new CheckDaoImp().selectbatchInsertCheck(week, xnxqh, zc, 0, a);
			if (list.size()>0) {
				for (int i = 0; i < list.size(); i++) {
					if(list.get(i).getRealpeople()== null) {
						list.get(i).setRealpeople(0);
					}
					list.get(i).setWeekid(zc);
					new CheckDaoImp().InsertCheck(list.get(i).getCurriculumid(), list.get(i).getWeekid(), list.get(i).getShouldpeople(), list.get(i).getRealpeople());
					successCount++;
				}
			}
			
			res.put("state", 0);
		} catch (Exception e) {
			e.printStackTrace();
			errorCount++;
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("CheckDaoImp层中selectbatchInsertCheck或InsertCheck出错");
		}
		System.out.println("数据插入结束");
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		long l2 = System.currentTimeMillis();
		System.out.println("考勤统计表更新或插入数据数据耗时："+(l2-l1));
		System.out.println("插入或更新成功"+successCount+"条，失败"+errorCount+"条");
		return res.toString();
	}
	/*public String InsertCheck(int page, int count) {
		JSONObject res =new JSONObject();
		try {
			LessonuseDaoImp lessonusedaoimp = new LessonuseDaoImp();
			TeamWeekFestivals teamweekfestivals = lessonusedaoimp.selectWeekCourseZC();
			Integer week = teamweekfestivals.getXqmc();//星期
			String xnxqh = teamweekfestivals.getXnxqh();//学年学期号
			Integer zc = teamweekfestivals.getZc();//周次
			int a = dao.selectbatchInsertCheckCount(week, xnxqh, zc);
			System.out.println("数据插入开始");
			if(a > 0) {
				int b = a / count;//设置分割的次数
				int c = a % count; //取余
				if(b == 0) {
					new Thread(new CheckData(page,count,week, xnxqh, zc)).start();
				}else if((b==1)&&(c==0)){
					new Thread(new CheckData(page,count,week, xnxqh, zc)).start();
				}else {
					int d = 0;
					if(c > 0 ) {
						d= b+1;
					}else {
						d = b;
					}
					for (int i = 0; i < d; i++) {
						new Thread(new CheckData(page,count,week, xnxqh, zc)).start();
						page++;
					}
				}
			}
			res.put("state", 0);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("CheckDaoImp层中selectbatchInsertCheck或InsertCheck出错");
		}
		System.out.println("数据插入结束");
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}*/
	
	/*public String InsertCheck() {
		JSONObject res =new JSONObject();
		try {
			List<Check> list = null;
			int page =1;
			int count = 100;
			LessonuseDaoImp lessonusedaoimp = new LessonuseDaoImp();
			TeamWeekFestivals teamweekfestivals = lessonusedaoimp.selectWeekCourseZC();
			int a = dao.selectbatchInsertCheckCount(teamweekfestivals.getXqmc(), teamweekfestivals.getXnxqh(), teamweekfestivals.getZc());
			System.out.println("数据插入开始");
			while((page-1)*count<a) {
				list = dao.selectbatchInsertCheck(teamweekfestivals.getXqmc(), teamweekfestivals.getXnxqh(), teamweekfestivals.getZc(), (page-1)*count, count);
				if (list.size()>0) {
					for (int i = 0; i < list.size(); i++) {
						if(list.get(i).getRealpeople()== null) {
							list.get(i).setRealpeople(0);
						}
						dao.InsertCheck(list.get(i).getcurriculumid(), list.get(i).getWeekid(), list.get(i).getShouldpeople(), list.get(i).getRealpeople());
					}
					page++;
				}else {
					return "selectbatchInsertCheck查询出错！";
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("CheckDaoImp层中selectbatchInsertCheck或InsertCheck出错");
		}
		System.out.println("数据插入结束");
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}*/

}
