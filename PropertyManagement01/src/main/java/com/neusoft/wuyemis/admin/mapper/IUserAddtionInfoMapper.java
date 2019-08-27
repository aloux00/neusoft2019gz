package com.neusoft.wuyemis.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.wuyemis.admin.model.UserAddtionInfoModel;
import com.neusoft.wuyemis.admin.model.UserInfoModel;
@Mapper
public interface IUserAddtionInfoMapper {
	 //增加
	public void insert(UserAddtionInfoModel behave) throws Exception;
	//修改
	public void update(UserAddtionInfoModel behave) throws Exception;
	//删除
	public void delete(UserAddtionInfoModel behave) throws Exception;
	//取得角色单个对象
	public UserAddtionInfoModel selectByNo(int no) throws Exception;
	//取得所有角色列表
	public List<UserAddtionInfoModel> selectListByAll() throws Exception;
}
