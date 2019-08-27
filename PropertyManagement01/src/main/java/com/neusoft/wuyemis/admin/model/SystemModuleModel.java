package com.neusoft.wuyemis.admin.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

//系统模块表
@Alias("SystemModule")
@Data
public class SystemModuleModel {
	private int MNO = 0;		//模块编号
	private String MNAME = null;		//模块名称
	
	
	
	
	
	

}
