package com.example.smart.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * ReadFile读取文件夹中的所有文件*/
public class ReadFile {
	/**
	 * 查询指定文件夹中当前文件夹中的文件，不包含下一级文件夹中的文件*/
	public List<String> readFile(String filePath){
		File file = new File(filePath);
		ArrayList<String> listFile = new ArrayList<String>();
		if(!file.isDirectory()){
			listFile.add(file.getName());
		}else if(file.isDirectory()){
			System.out.println("文件");
			String[] filelist = file.list();
			for(int i = 0;i < filelist.length;i++){
				File readfile = new File(filelist[i]);
				if (!readfile.isDirectory()) {
					listFile.add(readfile.getName());
				} else if (readfile.isDirectory()) {
					//readFile(filePath + "\\" + filelist[i]);//递归
				}
			}
		}
		for(int i = 0;i < listFile.size();i++){
			System.out.println(listFile.get(i));
		}
		return listFile;
	}
	
	/**
	 * 查询指定文件夹中所有文件夹的名称,并返回所有的文件夹的名称*/
	public List<String> readFileLog(String filePath){
		File file = new File(filePath);
		ArrayList<String> listFile = new ArrayList<String>();
		if(file.isDirectory()){
			System.out.println("文件");
			File[] filelist = file.listFiles();
			for(int i = 0; i < filelist.length; i++){
				if (filelist[i].isDirectory()) {
					listFile.add(filelist[i].getName());
				} 
			}
		}
		for(int i = 0; i < listFile.size(); i++){
			System.out.println(listFile.get(i));
		}
		return listFile;
	}
	
	
	/**
	 * 查询指定文件夹中当前文件夹中的文件名和文件大小，并将它们作为map的key和value存储*/
	public Map<String, Long> readFileToAndroid(String filePath){
		File file = new File(filePath);
		Map<String, Long> map = new HashMap<String, Long>();
		if(!file.isDirectory()){
			String fileName=file.getName();
			Long fileLong=file.length();
			map.put(fileName, fileLong);
		}else if(file.isDirectory()){
			System.out.println("文件");
			File[] filelist = file.listFiles();
			for(int i = 0;i < filelist.length;i++){
				File readfile = filelist[i];
				if (!readfile.isDirectory()) {
					String fileName=readfile.getName();
					Long fileLong=readfile.length();
					map.put(fileName, fileLong);
				} else if (readfile.isDirectory()) {
					//readFile(filePath + "\\" + filelist[i]);//递归
				}
			}
		}
		return map;
	}

}
