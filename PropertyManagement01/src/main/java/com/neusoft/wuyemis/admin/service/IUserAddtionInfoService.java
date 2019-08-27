package com.neusoft.wuyemis.admin.service;

import java.util.List;

import com.neusoft.wuyemis.admin.model.UserAddtionInfoModel;


public interface IUserAddtionInfoService {
	//注册用户
		public void add(UserAddtionInfoModel useraddtioninfoModel) throws Exception;
		//修改用户
		public void modify(UserAddtionInfoModel useraddtioninfoModel) throws Exception;
		//修改密码
		public void changePassword(String idString ,String password) throws Exception;
		
	    //删除
		public void delete(UserAddtionInfoModel useraddtioninfoModel) throws Exception;
		//取列表
		public List<UserAddtionInfoModel> selsetListByAll()throws Exception;
		//
		public UserAddtionInfoModel getById(String id) throws Exception;
}
