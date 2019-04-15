package com.example.smart.util;

import java.util.ArrayList;
import java.util.List;

public class StrUtil {
	public static String splitString(String str, String temp) {
		String result = null;
		if (str.indexOf(temp) != -1) {
			if (str.substring(str.indexOf(temp)).indexOf("&") != -1) {
				result = str.substring(str.indexOf(temp)).substring(str.substring(str.indexOf(temp)).indexOf("=") + 1,
						str.substring(str.indexOf(temp)).indexOf("&"));
 
			} else {
				result = str.substring(str.indexOf(temp)).substring(str.substring(str.indexOf(temp)).indexOf("=") + 1);
 
			}
		}
		return result;
	}
	
	public static List<String> removeDuplicate(List<String> list){  
		List<String> listTemp = new ArrayList<>();  
        for(int i=0;i<list.size();i++){  
            if(!listTemp.contains(list.get(i))){  
                listTemp.add(list.get(i));  
            }  
        }  
        return listTemp;  
    }  
}
