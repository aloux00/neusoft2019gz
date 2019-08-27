package com.neusoft.wuyemis.admin.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("UserAddtionInfo")
@Data
public class UserAddtionInfoModel {
	private String UUSERID = null;		//操作员登录账号
	private String SEX = null;		//
	private int AGE = 0;		//
	private String Mobible = null;
}
