package com.neusoft.wuyemis.admin.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;


import lombok.Data;
//系统操作员表


@Alias("UserInfo")
@Data
public class UserInfoModel implements Serializable {
	
		private String UUSERID = null;		//操作员登录账号
		private String UPASSWORD = null;		//登录密码	
		private String UNAME = null;		//姓名
		private String UserStatus = null;		//登录状态(Y/N)
		
		
}
