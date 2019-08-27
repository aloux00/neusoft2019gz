package com.neusoft.wuyemis.admin.service;

import java.util.List;

import com.neusoft.wuyemis.admin.model.SystemFunctionUserModel;
/*
 * 模块：admin
 * SystemFunctionUser的业务接口
 * @Author: 张云强
 */
public interface ISystemFuntionUserService {
    
	public void create(SystemFunctionUserModel systemfuntionMdoel) throws Exception;
	
	public void update(SystemFunctionUserModel systemfuntionMdoel) throws Exception;

	public void delete(SystemFunctionUserModel systemfuntionMdoel) throws Exception;

	public List<SystemFunctionUserModel> selsctListByAll() throws Exception;

	
}
