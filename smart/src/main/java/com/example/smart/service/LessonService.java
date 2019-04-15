package com.example.smart.service;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import net.smartschool.entity.Lesson;
import net.smartschool.entity.LessonBatch;
import net.smartschool.entity.LessonBatchNew;
import net.smartschool.entity.SynchronizationLessonA;
import net.smartschool.entity.TeamWeekFestivals;
import net.smartschool.impl.LessonDaoImp;
import net.smartschool.impl.LessonuseDaoImp;

public class LessonService {
	LessonDaoImp dao = new LessonDaoImp();
	private static final Logger logger = LogManager.getLogger();
	
	/**
	 * 查询所有课程分页显示
	 * @param page 页数
	 * @param count 显示条数
	 * @return
	 */
	public String selectLesson(int page ,int count) {
		JSONObject res = new JSONObject();
		try {
			List<Lesson> list = null; 
			int number=0;
			list = dao.selectLesson((page-1)*count,count);
			number=dao.selectLessonCount();
			if (!(list == null)) {
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
	 * 通过公司名，课程名，开始时间，结束时间 查询 
	 * @param lessonname 课程名
	 * @param start  开始时间
	 * @param end 结束时间
	 * @return
	 */
	public String selectLessonByLessonid(String lessonname, int page ,int count ) {
		JSONObject res = new JSONObject();
		try {
			List<Lesson> list = null; 
			int number=0;
			list = dao.selectLessonByLessonname(lessonname,(page-1)*count,count);
			number = dao.selectLessonCountByLessonname(lessonname);
			if (!(list == null)) {
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
	
	public String selectLessonByIp(String edeviceip,String userid, Integer days, Integer nearby,Integer teacherface) {
		JSONObject res = new JSONObject();
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
			List<LessonBatchNew> list = null;
			if(nearby!=null&&nearby==1) {//如果根据当前时间查当前设备对应的课程,nearby=1 表示查询当前课程
				if(null!=teacherface&&1!=teacherface) {//teacherface!=1表示根据老师id查询课程
					list = dao.selectLessonByIp2ToTeacherCard(userid, week, xnxqh, zc);
				}else {
					list = dao.selectLessonByIp2(edeviceip, week, xnxqh, zc);
				}
			}else {
				if(null!=teacherface&&1!=teacherface) {
					list = dao.selectLessonByIpToTeacherCard(userid, week, xnxqh, zc);
				}else {
					list = dao.selectLessonByIp(edeviceip, week, xnxqh, zc);
				}
			}
			if (!(list.size() == 0)) {
				List<LessonBatchNew> list2 = new ArrayList<LessonBatchNew>();
				//去掉重复的数据
				for (int i = 0; i < list.size(); i++) {
					boolean f = false;
					for (int j = i+1; j < list.size(); j++) {
						if((list.get(i).getCurriculumid()).equals(list.get(j).getCurriculumid())) {
							f = true;
						}
					}
					if(f==false) {
						list2.add(list.get(i));//如果curriculumid不存在重复的
					}
				}
				
				
				list = list2;//将去重后的数据赋值给list
				list.sort((l1,l2)->l1.getLessonjc().compareTo(l2.getLessonjc()));
				List<LessonBatch> list3 = new ArrayList<LessonBatch>();
				for (int i = 0; i < list.size(); i++) {
					LessonBatchNew lessonbatchnew = list.get(i);
					LessonBatch lessonbatch = new LessonBatch();
					lessonbatch.setLessonid(lessonbatchnew.getLessonid());
					lessonbatch.setLessonname(lessonbatchnew.getLessonname());
					lessonbatch.setLessontype(lessonbatchnew.getLessontype());
					lessonbatch.setLessonstart(lessonbatchnew.getLessonstart());
					lessonbatch.setLessonend(lessonbatchnew.getLessonend());
					lessonbatch.setDescribe(lessonbatchnew.getDescribe());
					lessonbatch.setCurriculumid(lessonbatchnew.getCurriculumid());
					lessonbatch.setTimestart(lessonbatchnew.getTimestart());
					lessonbatch.setTimeend(lessonbatchnew.getTimeend());
					lessonbatch.setSurecount(lessonbatchnew.getSurecount());
					lessonbatch.setTag(lessonbatchnew.getTag());
					lessonbatch.setUserid(lessonbatchnew.getUserid());
					lessonbatch.setUsername(lessonbatchnew.getUsername());
					lessonbatch.setSubclass(lessonbatchnew.getSubclass());
					lessonbatch.setClassroomid(lessonbatchnew.getClassroomid());
					lessonbatch.setLessoncount(lessonbatchnew.getLessoncount());
					lessonbatch.setLatecount(lessonbatchnew.getLatecount());
					lessonbatch.setEscapecount(lessonbatchnew.getEscapecount());
					lessonbatch.setClassroomname(lessonbatchnew.getClassroomname());
					lessonbatch.setLessonjc(lessonbatchnew.getLessonjc());
					lessonbatch.setXnxqh(lessonbatchnew.getXnxqh());
					list3.add(lessonbatch);
				}
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", list3);

			} else if(teacherface == null) {
				list = dao.selectLessonByIpForNext(edeviceip, week, xnxqh, zc);
				if (list.size() != 0) {
					List<LessonBatchNew> list2 = new ArrayList<LessonBatchNew>();
					//去掉重复的数据
					
					for (int i = 0; i < list.size(); i++) {
						boolean f = false;
						for (int j = i+1; j < list.size(); j++) {
							if((list.get(i).getCurriculumid()).equals(list.get(j).getCurriculumid())) {
								f = true;
							}
						}
						if(f==false) {
							list2.add(list.get(i));//如果curriculumid不存在重复的
						}
					}
					list = list2;//将去重后的数据赋值给list
					list.sort((l1,l2)->l1.getLessonjc().compareTo(l2.getLessonjc()));
					List<LessonBatch> list3 = new ArrayList<LessonBatch>();
					for (int i = 0; i < list.size(); i++) {
						LessonBatchNew lessonbatchnew = list.get(i);
						LessonBatch lessonbatch = new LessonBatch();
						lessonbatch.setLessonid(lessonbatchnew.getLessonid());
						lessonbatch.setLessonname(lessonbatchnew.getLessonname());
						lessonbatch.setLessontype(lessonbatchnew.getLessontype());
						lessonbatch.setLessonstart(lessonbatchnew.getLessonstart());
						lessonbatch.setLessonend(lessonbatchnew.getLessonend());
						lessonbatch.setDescribe(lessonbatchnew.getDescribe());
						lessonbatch.setCurriculumid(lessonbatchnew.getCurriculumid());
						lessonbatch.setTimestart(lessonbatchnew.getTimestart());
						lessonbatch.setTimeend(lessonbatchnew.getTimeend());
						lessonbatch.setSurecount(lessonbatchnew.getSurecount());
						lessonbatch.setTag(lessonbatchnew.getTag());
						lessonbatch.setUserid(lessonbatchnew.getUserid());
						lessonbatch.setUsername(lessonbatchnew.getUsername());
						lessonbatch.setSubclass(lessonbatchnew.getSubclass());
						lessonbatch.setClassroomid(lessonbatchnew.getClassroomid());
						lessonbatch.setLessoncount(lessonbatchnew.getLessoncount());
						lessonbatch.setLatecount(lessonbatchnew.getLatecount());
						lessonbatch.setEscapecount(lessonbatchnew.getEscapecount());
						lessonbatch.setClassroomname(lessonbatchnew.getClassroomname());
						lessonbatch.setLessonjc(lessonbatchnew.getLessonjc());
						lessonbatch.setXnxqh(lessonbatchnew.getXnxqh());
						list3.add(lessonbatch);
					}
					res.put("state", 0);
					res.put("msg", "查询配置成功！");
					res.put("data", list3);
				} else {
					res.put("state", 100);
					res.put("msg", "查询配置失败！");
				}
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
	
	//selectLessonByIpAndStudent与selectLessonByIp的区别是，前者查询的是学生，后者查询的是老师
	public String selectLessonByIpAndStudent(String edeviceip,String userid, Integer days, Integer nearby,Integer teacherface) {
		JSONObject res = new JSONObject();
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
			List<LessonBatchNew> list = null;
			if(nearby!=null&&nearby==1) {//如果根据当前时间查当前设备对应的课程
				list = dao.selectStudentLessonByIp2(userid, week, xnxqh, zc);
			}else {
				list = dao.selectStudentLessonByIp(userid, week, xnxqh, zc);
			}
			if (!(list.size() == 0)) {
				List<LessonBatchNew> list2 = new ArrayList<LessonBatchNew>();
				//去掉重复的数据
				for (int i = 0; i < list.size(); i++) {
					boolean f = false;
					for (int j = i+1; j < list.size(); j++) {
						if((list.get(i).getCurriculumid()).equals(list.get(j).getCurriculumid())) {
							f = true;
						}
					}
					if(f==false) {
						list2.add(list.get(i));//如果curriculumid不存在重复的
					}
				}
				list = list2;//将去重后的数据赋值给list
				list.sort((l1,l2)->l1.getLessonjc().compareTo(l2.getLessonjc()));
				List<LessonBatch> list3 = new ArrayList<LessonBatch>();
				for (int i = 0; i < list.size(); i++) {
					LessonBatchNew lessonbatchnew = list.get(i);
					LessonBatch lessonbatch = new LessonBatch();
					lessonbatch.setLessonid(lessonbatchnew.getLessonid());
					lessonbatch.setLessonname(lessonbatchnew.getLessonname());
					lessonbatch.setLessontype(lessonbatchnew.getLessontype());
					lessonbatch.setLessonstart(lessonbatchnew.getLessonstart());
					lessonbatch.setLessonend(lessonbatchnew.getLessonend());
					lessonbatch.setDescribe(lessonbatchnew.getDescribe());
					lessonbatch.setCurriculumid(lessonbatchnew.getCurriculumid());
					lessonbatch.setTimestart(lessonbatchnew.getTimestart());
					lessonbatch.setTimeend(lessonbatchnew.getTimeend());
					lessonbatch.setSurecount(lessonbatchnew.getSurecount());
					lessonbatch.setTag(lessonbatchnew.getTag());
					lessonbatch.setUserid(lessonbatchnew.getUserid());
					lessonbatch.setUsername(lessonbatchnew.getUsername());
					lessonbatch.setSubclass(lessonbatchnew.getSubclass());
					lessonbatch.setClassroomid(lessonbatchnew.getClassroomid());
					lessonbatch.setLessoncount(lessonbatchnew.getLessoncount());
					lessonbatch.setLatecount(lessonbatchnew.getLatecount());
					lessonbatch.setEscapecount(lessonbatchnew.getEscapecount());
					lessonbatch.setClassroomname(lessonbatchnew.getClassroomname());
					lessonbatch.setLessonjc(lessonbatchnew.getLessonjc());
					lessonbatch.setXnxqh(lessonbatchnew.getXnxqh());
					list3.add(lessonbatch);
				}
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", list3);

			} else if(teacherface == null) {
				//可能存在一个问题，那就是当查询的当天没有课程的时候，list只有一条
				list = dao.selectStudentLessonByIpForNext(userid, week, xnxqh, zc);
				if (list.size() != 0) {
					List<LessonBatchNew> list2 = new ArrayList<LessonBatchNew>();
					//去掉重复的数据
					for (int i = 0; i < list.size(); i++) {
						boolean f = false;
						for (int j = i+1; j < list.size(); j++) {
							if((list.get(i).getCurriculumid()).equals(list.get(j).getCurriculumid())) {
								f = true;
							}
						}
						if(f==false) {
							list2.add(list.get(i));//如果curriculumid不存在重复的
						}
					}
					list = list2;//将去重后的数据赋值给list
					list.sort((l1,l2)->l1.getLessonjc().compareTo(l2.getLessonjc()));
					List<LessonBatch> list3 = new ArrayList<LessonBatch>();
					for (int i = 0; i < list.size(); i++) {
						LessonBatchNew lessonbatchnew = list.get(i);
						LessonBatch lessonbatch = new LessonBatch();
						lessonbatch.setLessonid(lessonbatchnew.getLessonid());
						lessonbatch.setLessonname(lessonbatchnew.getLessonname());
						lessonbatch.setLessontype(lessonbatchnew.getLessontype());
						lessonbatch.setLessonstart(lessonbatchnew.getLessonstart());
						lessonbatch.setLessonend(lessonbatchnew.getLessonend());
						lessonbatch.setDescribe(lessonbatchnew.getDescribe());
						lessonbatch.setCurriculumid(lessonbatchnew.getCurriculumid());
						lessonbatch.setTimestart(lessonbatchnew.getTimestart());
						lessonbatch.setTimeend(lessonbatchnew.getTimeend());
						lessonbatch.setSurecount(lessonbatchnew.getSurecount());
						lessonbatch.setTag(lessonbatchnew.getTag());
						lessonbatch.setUserid(lessonbatchnew.getUserid());
						lessonbatch.setUsername(lessonbatchnew.getUsername());
						lessonbatch.setSubclass(lessonbatchnew.getSubclass());
						lessonbatch.setClassroomid(lessonbatchnew.getClassroomid());
						lessonbatch.setLessoncount(lessonbatchnew.getLessoncount());
						lessonbatch.setLatecount(lessonbatchnew.getLatecount());
						lessonbatch.setEscapecount(lessonbatchnew.getEscapecount());
						lessonbatch.setClassroomname(lessonbatchnew.getClassroomname());
						lessonbatch.setLessonjc(lessonbatchnew.getLessonjc());
						lessonbatch.setXnxqh(lessonbatchnew.getXnxqh());
						list3.add(lessonbatch);
					}
					res.put("state", 0);
					res.put("msg", "查询配置成功！");
					res.put("data", list3);
				} else {
					res.put("state", 100);
					res.put("msg", "查询配置失败！");
				}
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
	
	
	public String deleteLessonById(String delId) {
		JSONObject res = new JSONObject();
		String[] a=delId.split(",");
		try {
			int count = 0;
			for (int i = 0; i < a.length; i++) {
				Integer b=Integer.parseInt(a[i]);
				count = dao.deleteLessonById(b);
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
	public String selectLessonByClassroomId(String classroomId) {
		JSONObject res = new JSONObject();
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
			LessonBatchNew lessonBatchNew = null;
			lessonBatchNew = dao.selectLessonByClassroomId(classroomId, week, xnxqh, zc);
			if (lessonBatchNew != null) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", lessonBatchNew);
			} else {
				res.put("state", 100);
				res.put("msg", "本教室当天无未上课程！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	
	public String synchronizationlesson(String IP) {
		JSONObject res = new JSONObject();
		try {
			List<SynchronizationLessonA> list = dao.synchronizationlesson(IP);
			if (list != null&&(list.size()>0)) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", list);
			} else {
				res.put("state", 100);
				res.put("msg", "暂时无数据！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
}
