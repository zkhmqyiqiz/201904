package com.example.smart.entity;

import java.io.Serializable;

public class MessageData implements Serializable{
	private static final long serialVersionUID = -2629139400120272502L;
	private int updateCount;// 成功插入或者更新的数据
	private int errorCount;// 插入或更新失败的数据
	private String tableName;// 数据表的名称

	public int getUpdateCount() {
		return updateCount;
	}

	public void setUpdateCount(int updateCount) {
		this.updateCount = updateCount;
	}

	public int getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
