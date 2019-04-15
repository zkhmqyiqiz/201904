package com.example.smart.util;

import java.util.Date;
import java.util.List;

import net.smartschool.dao.RankingDao;
import net.smartschool.entity.Lessonuse;
import net.smartschool.entity.Tickup;
import net.smartschool.impl.RankingDaoImp;

public class StudentCheckData implements Runnable{
	private Integer page;
	private Integer count;
	private String xnxqh;//学年学期号
	private Integer zc;//周次

	public StudentCheckData(Integer page, Integer count, String xnxqh, Integer zc) {
		super();
		this.page = page;
		this.count = count;
		this.xnxqh = xnxqh;
		this.zc = zc;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int successCount = 0;//成功数量
		int errorCount = 0;//失败数量
		try {
			//根据学年学期号查询课程ID和学生ID
			RankingDao dao = new RankingDaoImp();
			List<Lessonuse> listTStudentCheck = dao.selectTStudentCheck(xnxqh,(page-1)*count,count);
			if(listTStudentCheck.size() > 0) {
				for (int i = 0; i < listTStudentCheck.size(); i++) {
					String userid = listTStudentCheck.get(i).getUserid();
					Integer lessonid = listTStudentCheck.get(i).getLessonid();
					
					List<Lessonuse> listLessonuseStudentCheck = dao.selectLessonuseStudentCheck(lessonid, userid);
					String teacherid = null;
					Integer alreadyclass = 0;
					Integer late = 0;
					Integer numbers = 0;//总共签到次数
					if(listLessonuseStudentCheck.size() > 0) {
						for (int j = 0; j < listLessonuseStudentCheck.size(); j++) {
							Lessonuse lessonuse = listLessonuseStudentCheck.get(j);
							Long curriculumid = lessonuse.getCurriculumid();
							teacherid = lessonuse.getUserid();//得到老师的编号
							int a = 0;//每一节课已经上了多少次
							if(lessonuse.getWeekend() <= zc) {
								a = 1+lessonuse.getWeekend()-lessonuse.getWeekstart();
							}else {
								a = zc+1-lessonuse.getWeekstart();
							}
							alreadyclass = alreadyclass + a;
							List<Tickup> listTickup = dao.selectTickupStudentCheck(userid, curriculumid);
							int b = listTickup.size();//每一节课的签到总次数
							int c = 0;//每一节课迟到的总次数
							for (int k = 0; k < listTickup.size(); k++) {
								if(listTickup.get(k).getSuccess()==1) {
									c++;
								}
							}
							late = late + c;
							numbers = numbers + b;
						}
						Float attendance = (float) (numbers/alreadyclass);
						Integer absence = alreadyclass - numbers;
						dao.insertStudentCheck(userid, lessonid, xnxqh, teacherid, alreadyclass, late, attendance, absence);
						successCount++;
					}
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			errorCount++;
		}
		System.out.println("student_check学生考勤表插入或更新成功"+successCount+"条，失败"+errorCount+"条");
		System.out.println(new Date());
		
	}

}
