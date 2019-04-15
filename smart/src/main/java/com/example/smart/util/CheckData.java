package com.example.smart.util;

import java.util.List;

import net.smartschool.entity.Check;
import net.smartschool.impl.CheckDaoImp;

public class CheckData  implements Runnable{
	private Integer page;
	private Integer count;
	private Integer week;//星期
	private String xnxqh;//学年学期号
	private Integer zc;//周次
	



	public CheckData(Integer page, Integer count, Integer week, String xnxqh, Integer zc) {
		super();
		this.page = page;
		this.count = count;
		this.week = week;
		this.xnxqh = xnxqh;
		this.zc = zc;
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		int successCount = 0;//成功数量
		int errorCount = 0;//失败数量
		try {
			List<Check> list = null;
			list = new CheckDaoImp().selectbatchInsertCheck(week, xnxqh, zc, (page-1)*count, count);
			if (list.size()>0) {
				for (int i = 0; i < list.size(); i++) {
					if(list.get(i).getRealpeople()== null) {
						list.get(i).setRealpeople(0);
					}
					list.get(i).setWeekid(zc);
					new CheckDaoImp().InsertCheck(list.get(i).getCurriculumid(), list.get(i).getWeekid(), list.get(i).getShouldpeople(), list.get(i).getRealpeople());
					successCount++;
				}
			}else {
				System.out.println("selectbatchInsertCheck查询出错！"); 
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorCount++;
		}
		System.out.println("check考勤表插入或更新成功"+successCount+"条，失败"+errorCount+"条");
		
	}

}
