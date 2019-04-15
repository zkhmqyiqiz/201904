package com.example.smart.util;

/**
 * 将数据库中表示星期的一、二转化为1,2等*/
public class SwitchWeek {
	public static int switchWeek(String weekName) {
 		switch (weekName) {
	      case "一":
	             return 1;
	      case "二":
	             return 2;
	      case "三":
	             return 3;
	      case "四":
	             return 4;
	      case "五":
	             return 5;
	      case "六":
	    	     return 6;
	      default:
	    	     return 7;
        }
 		
 	}

}
