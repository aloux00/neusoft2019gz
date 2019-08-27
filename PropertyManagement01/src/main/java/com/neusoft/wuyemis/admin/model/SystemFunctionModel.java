package com.neusoft.wuyemis.admin.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

//系统功能表
@Alias("SystemFunction")
@Data
public class SystemFunctionModel {
	private int FUNNO = 0;		//功能编号
	private int MNO = 0;		//模块编号
	private String FUNNAME = null;		//功能名称
	private String FUNURL = null;		//URL地址
	private int LeveNo = 0;		//功能级别号
	
	
}
