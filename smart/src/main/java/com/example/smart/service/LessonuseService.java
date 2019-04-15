package com.example.smart.service;

import java.util.Iterator;
import java.util.List;

import com.example.smart.entity.TeamWeekFestivals;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import net.smartschool.dao.AttendClassDao;
import net.smartschool.dao.ElectricDeviceDao;
import net.smartschool.dao.LessonDao;
import net.smartschool.dao.LessonuseDao;
import net.smartschool.dao.PPTDao;
import net.smartschool.dao.SubjectDao;
import net.smartschool.dao.TickupDao;
import net.smartschool.dao.UserDao;
import net.smartschool.entity.AttendClass;
import net.smartschool.entity.ElectricDevice;
import net.smartschool.entity.LessonBatchNew;
import net.smartschool.entity.LessonuseNote;
import net.smartschool.entity.PPT;
import net.smartschool.entity.TeamWeekFestivals;
import net.smartschool.entity.TempCurriculum;
import net.smartschool.entity.User;
import net.smartschool.entity.WeekCourse;
import net.smartschool.impl.AttendClassDaoImp;
import net.smartschool.impl.ElectricDeviceImpl;
import net.smartschool.impl.LessonDaoImp;
import net.smartschool.impl.LessonuseDaoImp;
import net.smartschool.impl.PPTDaoImpl;
import net.smartschool.impl.SubjectDaoImpl;
import net.smartschool.impl.TickupDaoImp;
import net.smartschool.impl.UserDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class LessonuseService {
	LessonuseDaoImp dao =new LessonuseDaoImp();
	private static final Logger logger = LogManager.getLogger();
	public String selectLessonuse(int page ,int count) {
		JSONObject res=new JSONObject();
		try {
			List<LessonuseNote> list = null;
			int number=0;
			list = dao.selectLessonuse((page - 1) * count, count);
			number=dao.selectCount();
			if (list != null) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", list);
				res.put("numbers", number);
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
	
	
	/**
	 * 根据课程名称模糊查询
	 * @param userid
	 * @param page
	 * @param count
	 * @return
	 */
	public String selectLessonuseByUserid(String userid ,int page ,int count) {
		JSONObject res =new JSONObject();
		try {
			List<LessonuseNote> list = null;
			int number=0;
			if (userid != null &&!"".equals(userid.trim())) {//userid的值为课堂模糊查询的条件
			     //则字符串不为空或空格
				list = dao.selectLessonuseByUserid(userid, (page-1)*count, count);
				number=dao.selectLessonuseByUseridCount(userid);
			}else {//无条件查询全部
				list = dao.selectLessonuse(page, count);
				number=dao.selectCount();
			}
			
			if (list != null) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", list);
				res.put("numbers", number);
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
	
	
	public String deleteLessonUseById(String delId) {
		JSONObject res = new JSONObject();
		String[] a=delId.split(",");
		try {
			int count = 0;
			for (int i = 0; i < a.length; i++) {
				Long b = Long.parseLong(a[i]);
				count = dao.deleteLessonUseById(b);
				//判断lessonuse表当中，是否删除成功
				/*if(count>0) {
					int temp = new LessonformDaoImp().deleteLessonFromById(b);//查询对应的lessonform表中是否有相同的curriculumid
					if(temp>0) {
						new LessonformDaoImp().deleteLessonFromById(b);//因为lessonform表的主键同样是lessonuse的主键，所以删除的时候
					}
					
				}*/
			}
			if (count>0) {
				res.put("state", 0);
				res.put("msg", "删除成功！");
				
			} else {
				res.put("state", 100);
				res.put("msg", "删除失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	public TeamWeekFestivals selectWeekCourses() {
		TeamWeekFestivals teamWeekFestivals = new TeamWeekFestivals();
		TeamWeekFestivals teamweekfestivals = null;
		try {
			teamweekfestivals = dao.selectWeekCourse();
			if(teamweekfestivals == null) {
				teamweekfestivals = dao.selectWeekCourseZC();
				int a = dao.selectWeekCourseJC(teamweekfestivals.getXnxqh())+1;
				teamWeekFestivals.setJc(a);
				teamWeekFestivals.setXnxqh(teamweekfestivals.getXnxqh());
				teamWeekFestivals.setXqmc(teamweekfestivals.getXqmc());
				teamWeekFestivals.setZc(teamweekfestivals.getZc());
			}else {
				teamWeekFestivals.setJc(teamweekfestivals.getJc());
				teamWeekFestivals.setXnxqh(teamweekfestivals.getXnxqh());
				teamWeekFestivals.setXqmc(teamweekfestivals.getXqmc());
				teamWeekFestivals.setZc(teamweekfestivals.getZc());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info("LessonuseDaoImp实现类中selectWeekCourse方法数据库错误");
		}
		return teamWeekFestivals;//LessonuseService
	}
	
	public String selectWeekCourse(String userid,Integer page,Integer count) {
		JSONObject res = new JSONObject();
		TeamWeekFestivals teamWeekFestivals = null;
		try {
			LessonuseService service = new LessonuseService();
			teamWeekFestivals = service.selectWeekCourses();
			if(teamWeekFestivals == null) {
				res.put("state", 100);
				res.put("msg", "LessonuseDaoImp实现类中selectWeekCourse方法查询失败");
				return res.toString();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("LessonuseDaoImp实现类中selectWeekCourse方法数据库错误");
			return res.toString();
		}
		List<WeekCourse> TeachList = null;
		try {
			int jc = teamWeekFestivals.getJc();//节次
			int xqmc =teamWeekFestivals.getXqmc();//星期
			int zc = teamWeekFestivals.getZc();//周次
			int a = dao.selectWeekCourseCount(userid, teamWeekFestivals.getXnxqh(), zc);//本周总共有多少节课
			TeachList = dao.selectWeekCourseTeach(userid, teamWeekFestivals.getXnxqh(), teamWeekFestivals.getZc(),(page - 1) * count, count);
			if(TeachList!=null) {
				for (int i = 0; i < TeachList.size(); i++) {
					if(TeachList.get(i).getWeek() > xqmc) {
						TeachList.get(i).setStatus("未授");
					}else if(TeachList.get(i).getWeek() == xqmc) {
						if(TeachList.get(i).getLessonJc() >= jc) {
							TeachList.get(i).setStatus("未授");
						}else {
							TeachList.get(i).setStatus("已授");
						}
					}else {
						TeachList.get(i).setStatus("已授");
					}
					TeachList.get(i).setZc(zc);
				}
			}
			res.put("state", 0);
			res.put("msg", "查询成功");
			res.put("data", TeachList);
			res.put("numbers", a);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("LessonuseDaoImp实现类中selectWeekCourseTeach方法数据库错误");
			return res.toString();
		}
		return res.toString();
	}
	
	
	public String selectMonthCourse(String userid,Integer page,Integer count) {
		JSONObject res = new JSONObject();
		TeamWeekFestivals teamWeekFestivals = null;
		try {
			LessonuseService service = new LessonuseService();
			teamWeekFestivals = service.selectWeekCourses();
			if(teamWeekFestivals == null) {
				res.put("state", 100);
				res.put("msg", "LessonuseDaoImp实现类中selectWeekCourse方法查询失败");
				return res.toString();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("LessonuseDaoImp实现类中selectWeekCourse方法数据库错误");
			return res.toString();
		}
		List<WeekCourse> TeachList = null;
		try {
			int jc = teamWeekFestivals.getJc();//节次
			int xqmc =teamWeekFestivals.getXqmc();//星期
			int zc = teamWeekFestivals.getZc();//周次
			int a = dao.selectMonthCourseCount(userid, teamWeekFestivals.getXnxqh());
			TeachList = dao.selectMonthCourse(userid, teamWeekFestivals.getXnxqh(), (page - 1) * count, count);
			if(TeachList!=null) {
				for (int i = 0; i < TeachList.size(); i++) {
					if(TeachList.get(i).getZc() > zc) {
						TeachList.get(i).setStatus("未授");
					}else if(TeachList.get(i).getZc() < zc) {
						TeachList.get(i).setStatus("已授");
					}else {
						if(TeachList.get(i).getWeek() > xqmc) {
							TeachList.get(i).setStatus("未授");
						}else if(TeachList.get(i).getWeek() == xqmc) {
							if(TeachList.get(i).getLessonJc() >= jc) {
								TeachList.get(i).setStatus("未授");
							}else {
								TeachList.get(i).setStatus("已授");
							}
						}else {
							TeachList.get(i).setStatus("已授");
						}
					}
				}
			}
			res.put("state", 0);
			res.put("msg", "查询成功");
			res.put("data", TeachList);
			res.put("numbers", a);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("LessonuseDaoImp实现类中selectMonthCourse方法数据库错误");
			return res.toString();
		}
		return res.toString();
	}
	
	/*public String selectSemesterCourse(String userid,Integer page,Integer count) {
		JSONObject res = new JSONObject();
		TeamWeekFestivals teamWeekFestivals = null;
		try {
			LessonuseService service = new LessonuseService();
			teamWeekFestivals = service.selectWeekCourses();
			if(teamWeekFestivals == null) {
				res.put("state", 100);
				res.put("msg", "LessonuseDaoImp实现类中selectWeekCourse方法查询失败");
				return res.toString();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("LessonuseDaoImp实现类中selectWeekCourse方法数据库错误");
			return res.toString();
		}
		List<WeekCourse> TeachList = null;
		try {
			int jc = teamWeekFestivals.getJc();//节次
			int xqmc =teamWeekFestivals.getXqmc();//星期
			int zc = teamWeekFestivals.getZc();//周次
			int a = dao.selectSemesterCourseCount(userid, teamWeekFestivals.getXnxqh());
			TeachList = dao.selectSemesterCourse(userid, teamWeekFestivals.getXnxqh(), (page - 1) * count, count);
			if(TeachList!=null) {
				for (int i = 0; i < TeachList.size(); i++) {
					if(TeachList.get(i).getZc() > zc) {
						TeachList.get(i).setStatus("未授");
					}else if(TeachList.get(i).getZc() < zc) {
						TeachList.get(i).setStatus("已授");
					}else {
						if(TeachList.get(i).getWeek() > xqmc) {
							TeachList.get(i).setStatus("未授");
						}else if(TeachList.get(i).getWeek() == xqmc) {
							if(TeachList.get(i).getLessonJc() >= jc) {
								TeachList.get(i).setStatus("未授");
							}else {
								TeachList.get(i).setStatus("已授");
							}
						}else {
							TeachList.get(i).setStatus("已授");
						}
					}
				}
			}
			res.put("state", 0);
			res.put("msg", "查询成功");
			res.put("data", TeachList);
			res.put("numbers", a);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("LessonuseDaoImp实现类中selectSemesterCourse方法数据库错误");
			return res.toString();
		}
		return res.toString();
	}*/
	
	public String selectSemesterCourse(String userid,Integer page,Integer count) {
		JSONObject res = new JSONObject();
		TeamWeekFestivals teamWeekFestivals = null;
		try {
			LessonuseService service = new LessonuseService();
			teamWeekFestivals = service.selectWeekCourses();
			if(teamWeekFestivals == null) {
				res.put("state", 100);
				res.put("msg", "LessonuseDaoImp实现类中selectWeekCourse方法查询失败");
				return res.toString();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("LessonuseDaoImp实现类中selectWeekCourse方法数据库错误");
			return res.toString();
		}
		List<WeekCourse> TeachList = null;
		try {
			int jc = teamWeekFestivals.getJc();//节次
			int xqmc =teamWeekFestivals.getXqmc();//星期
			int zc = teamWeekFestivals.getZc();//周次
			//int a = dao.selectSemesterCourseCount(userid, teamWeekFestivals.getXnxqh());
			TeachList = dao.selectSemesterCourse(userid, teamWeekFestivals.getXnxqh(), (page - 1) * count, count);//不分页查询，page和count没有用到
			Iterator<WeekCourse> iterator = TeachList.iterator();
			System.out.println(TeachList.size());
			while(iterator.hasNext()) {
				WeekCourse  weekcourse = iterator.next();
				int zc1 = weekcourse.getZc();
				int weekstart = weekcourse.getWeekstart();
				int weekend = weekcourse.getWeekend();
				if(zc1< weekstart || zc1 > weekend) {
					iterator.remove();
				}
			}
			int a = TeachList.size();
			System.out.println(TeachList.size());
			int b = (page-1)* count;
			int c = 0;
			if(TeachList!=null) {
				if( page*count > TeachList.size()) {
					 c = TeachList.size();
				}else {
					c = page*count;
				}
				for (int i = b; i < c; i++) {
					if(TeachList.get(i).getZc() > zc) {
						TeachList.get(i).setStatus("未授");
					}else if(TeachList.get(i).getZc() < zc) {
						TeachList.get(i).setStatus("已授");
					}else {
						if(TeachList.get(i).getWeek() > xqmc) {
							TeachList.get(i).setStatus("未授");
						}else if(TeachList.get(i).getWeek() == xqmc) {
							if(TeachList.get(i).getLessonJc() >= jc) {
								TeachList.get(i).setStatus("未授");
							}else {
								TeachList.get(i).setStatus("已授");
							}
						}else {
							TeachList.get(i).setStatus("已授");
						}
					}
				}
			}
			TeachList = TeachList.subList(b, c);
			res.put("state", 0);
			res.put("msg", "查询成功");
			res.put("data", TeachList);
			res.put("numbers", a);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("LessonuseDaoImp实现类中selectSemesterCourse方法数据库错误");
			return res.toString();
		}
		return res.toString();
	}
	public String iclassStart(String userid, String ip, int pptid) {
		JSONObject res = new JSONObject();
		ElectricDeviceDao eDeviceDao = new ElectricDeviceImpl();
		LessonuseDao lessonuseDao = new LessonuseDaoImp();
		LessonDao lessonDao = new LessonDaoImp();
		try {
			ElectricDevice electricDevice = eDeviceDao.selectClassroomidByComputerip(ip);
			TeamWeekFestivals xnxqhAndZC = lessonuseDao.selectWeekCourseZC();
			if(xnxqhAndZC==null) {
				res.put("state", 0);
				res.put("msg", "数据库没有数据！");
				return res.toString();
			}
			String classroomid = electricDevice.getClassroomid();
			String classroomname = electricDevice.getClassroomname();
			int zc = xnxqhAndZC.getZc();
			UserDao userDao = new UserDaoImpl();
			User user = userDao.selectUserById(userid, "");
			String username = user.getUsername();
			LessonBatchNew lessonBatchNew = lessonDao.selectForiclassStart(userid, xnxqhAndZC.getXqmc(), xnxqhAndZC.getXnxqh(), zc);
			if (lessonBatchNew != null) {
				AttendClass attendClass = new AttendClass();
				attendClass.setCurriculumid(lessonBatchNew.getCurriculumid());
				attendClass.setZc(zc);
				attendClass.setPptid(pptid);;
				attendClass.setAttendclasstype(0);
				lessonDao.insertIntoAttendclass(attendClass);
				String token = "0<br>" + lessonBatchNew.getCurriculumid() + "<br>"+ zc + "<br>" + pptid;
				res.put("state", 0);
				res.put("msg", "正常课，开始上课成功！");
				res.put("token", token);
				res.put("lessonname", lessonBatchNew.getLessonname());
				res.put("classroomname", classroomname);
				res.put("username", username);
				res.put("attendclassid", attendClass.getAttendclassid());
			} else {
				TempCurriculum tempCurriculum = new TempCurriculum();
				tempCurriculum.setUserid(userid);
				tempCurriculum.setClassroomid(classroomid);
				lessonDao.insertIntoTempcurriculum(tempCurriculum);
				AttendClass attendClass = new AttendClass();
				attendClass.setCurriculumid((long)tempCurriculum.getTempcurriculumid());
				attendClass.setZc(zc);
				attendClass.setPptid(pptid);;
				attendClass.setAttendclasstype(1);
				/**
				 * 返回attendclassid
				 */
				lessonDao.insertIntoAttendclass(attendClass);
				String token = "1<br>" + tempCurriculum.getTempcurriculumid() + "<br>"+ zc + "<br>" + pptid;
				res.put("state", 0);
				res.put("msg", "临时课，开始上课成功！");
				res.put("token", token);
				res.put("lessonname", "临时课无课程名！");
				res.put("classroomname", classroomname);
				res.put("username", username);
				res.put("attendclassid", attendClass.getAttendclassid());
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}

	public String scanForJoinClass(String token, String userid) {
		JSONObject res = new JSONObject();
		// 分割字符串
		String[] array = token.split("<br>");
		int type = Integer.parseInt(array[0]);
		long curriculumid = Integer.parseInt(array[1]);
		int zc = Integer.parseInt(array[2]);
		int pptid = Integer.parseInt(array[3]);
		//查询用户，判断是老师还是学生
		AttendClassDao attendClassDao = new AttendClassDaoImp();
		UserDao userDao = new UserDaoImpl();
		PPTDao pptDao = new PPTDaoImpl();
		SubjectDao subjectDao = new SubjectDaoImpl();
		TickupDao tickupDao = new TickupDaoImp();
		try {
			User user = userDao.selectUserById(userid, "");
			int role = user.getRole();
			PPT ppt = pptDao.selectPPTById(pptid);
			List<Integer> list = subjectDao.selectSubjectsInOnePPT(pptid);
			AttendClass attendClass = attendClassDao.selectAttendClassByZC(curriculumid, zc);
			res.put("state", 0);
			res.put("msg", "返回ppt信息成功！");
			res.put("url", ppt.getPpturl());
			res.put("pptid", pptid);
			res.put("pagelist", list);
			res.put("attendclassid", attendClass.getAttendclassid());
			if (role == 0) {
				//若是老师，直接返回ppt相关信息
			}
			if (role == 1) {
				//学生还需要在签到表插入数据
				if (type == 0) {
					tickupDao.addTickup(userid, zc, curriculumid, 0, 1);
				}
				if (type == 1) {
					tickupDao.addTickup(userid, zc, curriculumid, 0, 3);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String selectDayCourse(String userid,Integer page,Integer count) {
		JSONObject res = new JSONObject();
		TeamWeekFestivals teamWeekFestivals = null;
		try {
			LessonuseService service = new LessonuseService();
			teamWeekFestivals = service.selectWeekCourses();
			if(teamWeekFestivals == null) {
				res.put("state", 100);
				res.put("msg", "LessonuseDaoImp实现类中selectWeekCourse方法查询失败");
				return res.toString();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("LessonuseDaoImp实现类中selectWeekCourse方法数据库错误");
			return res.toString();
		}
		List<WeekCourse> TeachList = null;
		try {
			int jc = teamWeekFestivals.getJc();//节次
			int xqmc =teamWeekFestivals.getXqmc();//星期
			int zc = teamWeekFestivals.getZc();//周次
			int a = dao.selectDayCourseCount(userid, teamWeekFestivals.getXnxqh());
			TeachList = dao.selectDayCourse(userid, teamWeekFestivals.getXnxqh(), (page - 1) * count, count);
			if(TeachList!=null) {
				for (int i = 0; i < TeachList.size(); i++) {
					if(TeachList.get(i).getZc() > zc) {
						TeachList.get(i).setStatus("未授");
					}else if(TeachList.get(i).getZc() < zc) {
						TeachList.get(i).setStatus("已授");
					}else {
						if(TeachList.get(i).getWeek() > xqmc) {
							TeachList.get(i).setStatus("未授");
						}else if(TeachList.get(i).getWeek() == xqmc) {
							if(TeachList.get(i).getLessonJc() >= jc) {
								TeachList.get(i).setStatus("未授");
							}else {
								TeachList.get(i).setStatus("已授");
							}
						}else {
							TeachList.get(i).setStatus("已授");
						}
					}
				}
			}
			res.put("state", 0);
			res.put("msg", "查询成功");
			res.put("data", TeachList);
			res.put("numbers", a);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("LessonuseDaoImp实现类中selectDaycourse方法数据库错误");
			return res.toString();
		}
		return res.toString();
	}

	public String selectCourseStat(String userid) {
		JSONObject res = new JSONObject();
		TeamWeekFestivals teamWeekFestivals = null;
		try {
			LessonuseService service = new LessonuseService();
			teamWeekFestivals = service.selectWeekCourses();
			if(teamWeekFestivals == null) {
				res.put("state", 100);
				res.put("msg", "LessonuseDaoImp实现类中selectWeekCourse方法查询失败");
				return res.toString();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("LessonuseDaoImp实现类中selectWeekCourse方法数据库错误");
			return res.toString();
		}
		List<WeekCourse> TeachList = null;
		List<WeekCourse> TeachList2 = null;
		List<WeekCourse> TeachList3 = null;
		Integer nonecount1 = 0;
		Integer realcount1 = 0;
		Integer nonecount2 = 0;
		Integer realcount2 = 0;
		Integer nonecount3 = 0;
		Integer realcount3 = 0;
		try {
			int jc = teamWeekFestivals.getJc();//节次
			int xqmc =teamWeekFestivals.getXqmc();//星期
			int zc = teamWeekFestivals.getZc();//周次
			TeachList = dao.selectWeekCourseStat(userid, teamWeekFestivals.getXnxqh(), teamWeekFestivals.getZc());
			TeachList2 = dao.selectMonthCourseStat(userid, teamWeekFestivals.getXnxqh());
			TeachList3 = dao.selectSemesterCourseStat(userid, teamWeekFestivals.getXnxqh());
			if(TeachList!=null) {

				for (int i = 0; i < TeachList.size(); i++) {
					if(TeachList.get(i).getWeek() > xqmc) {
						nonecount1++;
					}else if(TeachList.get(i).getWeek() == xqmc) {
						if(TeachList.get(i).getLessonJc() >= jc) {
							nonecount1++;
						}else {
							realcount1++;
						}
					}else {
						realcount1++;
					}
					TeachList.get(i).setZc(zc);
				}

			}
			if(TeachList2!=null) {
				for (int i = 0; i < TeachList2.size(); i++) {
					if(TeachList2.get(i).getZc() > zc) {
						nonecount2++;
					}else if(TeachList2.get(i).getZc() < zc) {
						realcount2++;
					}else {
						if(TeachList2.get(i).getWeek() > xqmc) {
							nonecount2++;
						}else if(TeachList2.get(i).getWeek() == xqmc) {
							if(TeachList2.get(i).getLessonJc() >= jc) {
								nonecount2++;
							}else {
								realcount2++;
							}
						}else {
							realcount2++;
						}
					}
				}
			}
			if(TeachList3!=null) {
				for (int i = 0; i < TeachList3.size(); i++) {
					if(TeachList3.get(i).getZc() > zc) {
						nonecount3++;
					}else if(TeachList3.get(i).getZc() < zc) {
						realcount3++;
					}else {
						if(TeachList3.get(i).getWeek() > xqmc) {
							nonecount3++;
						}else if(TeachList3.get(i).getWeek() == xqmc) {
							if(TeachList3.get(i).getLessonJc() >= jc) {
								nonecount3++;
							}else {
								realcount3++;
							}
						}else {
							realcount3++;
						}
					}
				}
			}
			res.put("state", 0);
			res.put("msg", "查询成功");
			res.put("weeknonecount", nonecount1);
			res.put("weekrealcount", realcount1);
			res.put("monthnonecount", nonecount2);
			res.put("monthrealcount", realcount2);
			res.put("semesternonecount", nonecount3);
			res.put("semesterrealcount", realcount3);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
			logger.info("LessonuseDaoImp实现类中selectWeekCourseTeach方法数据库错误");
			return res.toString();
		}
		return res.toString();
	}
}
