package com.neusoft.wuyemis.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.neusoft.wuyemis.admin.model.UserInfoModel;



@Mapper
public interface IUserInfoMapper {
	   //增加
		public void add(UserInfoModel user) throws Exception;
		//修改
		public void modify(UserInfoModel user) throws Exception;
		//删除
		public void delete(UserInfoModel user) throws Exception;
		//取得角色单个对象
		public UserInfoModel getByNo(int no) throws Exception;
		//取得所有角色列表
		public List<UserInfoModel> getListByAll() throws Exception;
		//取得所有角色列表,分页模式
		public List<UserInfoModel> getListByAllWithPage(int rows,int page) throws Exception;
		//取得角色的个数
		public int getCountByAll() throws Exception;
		//取得角色页数
		public int getPagaCountByAll(int rows) throws Exception;
}
