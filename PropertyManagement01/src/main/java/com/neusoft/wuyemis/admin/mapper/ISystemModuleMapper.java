package com.neusoft.wuyemis.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.wuyemis.admin.model.SystemModuleModel;
/*
	 * 模块：admin
	 * SystemModule的DAO层接口
	 * @Author: 张云强
	 */
@Mapper
public interface ISystemModuleMapper {
	
	
	     
		public void create(SystemModuleModel systemModuleModel) throws Exception;
		
		public void update(SystemModuleModel systemModuleModel) throws Exception;

		public void delete(SystemModuleModel systemModuleModel) throws Exception;

		public List<SystemModuleModel> selsctListByAll() throws Exception;
}
