package com.neusoft.wuyemis.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuyemis.admin.mapper.IUserInfoMapper;
import com.neusoft.wuyemis.admin.model.UserInfoModel;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserInfoServiceImpl implements IUserInfoMapper {
	
	@Autowired
	private IUserInfoMapper userInfoMapper=null;
	@Override
	public void add(UserInfoModel userinfo) throws Exception {
		userInfoMapper.add(userinfo);

	}

	@Override
	public void modify(UserInfoModel userinfo) throws Exception {
	    

	}

	@Override
	public void delete(UserInfoModel userinfo) throws Exception {
		userInfoMapper.delete(userinfo);

	}

	@Override
	public UserInfoModel getByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfoModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfoModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountByAll() throws Exception {
		
		return userInfoMapper.getCountByAll() ;
	}

	@Override
	public int getPagaCountByAll(int rows) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
