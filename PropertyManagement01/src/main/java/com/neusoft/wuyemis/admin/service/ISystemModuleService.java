package com.neusoft.wuyemis.admin.service;

import java.util.List;

import com.neusoft.wuyemis.admin.model.SystemModuleModel;
/*
 * 模块：admin
 * SystemModule的业务接口
 * @Author: 张云强
 */
public interface ISystemModuleService {
	 
		public void create(SystemModuleModel systemModuleModel) throws Exception;
		
		public void update(SystemModuleModel systemModuleModel) throws Exception;

		public void delete(SystemModuleModel systemModuleModel) throws Exception;

		public List<SystemModuleModel> selsctListByAll() throws Exception;
		
}
