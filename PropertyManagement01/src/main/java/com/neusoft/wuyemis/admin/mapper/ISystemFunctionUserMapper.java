package com.neusoft.wuyemis.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.wuyemis.admin.model.SystemFunctionUserModel;
/*
	 * 模块：admin
	 * SystemFunctionUser的Dao层接口
	 * @Author: 张云强
	 */
@Mapper
public interface ISystemFunctionUserMapper {

	    public void create(SystemFunctionUserModel systemfuntionMdoel) throws Exception;
		
		public void update(SystemFunctionUserModel systemfuntionMdoel) throws Exception;

		public void delete(SystemFunctionUserModel systemfuntionMdoel) throws Exception;

		public List<SystemFunctionUserModel> selsctListByAll() throws Exception;
}
