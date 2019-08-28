package com.neusoft.wuyemis.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuyemis.admin.mapper.IUserAddtionInfoMapper;
import com.neusoft.wuyemis.admin.model.UserAddtionInfoModel;

@Service
@Transactional
public class UserAddtionInfoServiceImpl implements IUserAddtionInfoMapper {
	
	@Autowired
	private IUserAddtionInfoMapper userAddtionInfoMapper=null;
	@Override
	public void insert(UserAddtionInfoModel behave) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(UserAddtionInfoModel behave) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(UserAddtionInfoModel behave) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public UserAddtionInfoModel selectByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAddtionInfoModel> selectListByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
