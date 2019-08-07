package com.neusoft.busmis.security.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.neusoft.busmis.security.dao.IFunctionDao;
import com.neusoft.busmis.security.model.FunctionModel;
import com.neusoft.busmis.security.service.IFunctionService;
//系统功能业务实现类
@Service
@Transactional(rollbackFor=Exception.class)
public class FunctionServiceImpl implements IFunctionService {

	@Override
	public void create(FunctionModel function) throws Exception {
		
	}

	@Override
	public void update(FunctionModel function) throws Exception {
		

	}

	@Override
	public void delete(FunctionModel fm) throws Exception{
		

	}

	@Override
	public List<FunctionModel> selectListByAll() throws Exception {
		
		
		return null;
	}
	
	@Override
	public List<FunctionModel> selectListByAllWithModuleByNestedSelect() throws Exception {
		
		return null;
	}

	@Override
	public List<FunctionModel> selectListByAllWithModuleByNestedResultMap() throws Exception {
	
		return null;
	}
	
	

	@Override
	public List<FunctionModel> selectListByModule(int moduleNo) throws Exception {
	
		return null;
		
	}

	@Override
	public FunctionModel selectByNo(int no) throws Exception {
		
		
		return null;
	}

	@Override
	public int selectCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectCountByModule(int moduleNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
