package com.neusoft.wuyemis.admin.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

//系统功能权限表
@Alias("SystemFunctionUser")
@Data
public class SystemFunctionUserModel {
	private int FunNo = 0;		//功能号
	private String UserID = null;		//操作员账号
	
	

}
