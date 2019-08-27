package com.neusoft.wuyemis.admin.service;

import java.util.List;

import com.neusoft.wuyemis.admin.model.SystemFunctionModel;

/*
 * 模块：admin
 * SystemFuntion的业务接口
 * @Author: 张云强
 */
public interface ISystemFuntionService {
   
	    //增
		public void create(SystemFunctionModel systemfuntionModel) throws Exception;
		
		public void update(SystemFunctionModel systemfuntionModel) throws Exception;
		//删
		public void delete(SystemFunctionModel systemfuntionModel) throws Exception;
	    
		public List<SystemFunctionModel> selsctListByAll() throws Exception;
	
}
