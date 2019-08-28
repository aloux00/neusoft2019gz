package com.neusoft.wuyemis.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuyemis.admin.mapper.IUserInfoMapper;
import com.neusoft.wuyemis.admin.model.UserInfoModel;
import com.neusoft.wuyemis.admin.service.IUserInfoService;

@Service
@Transactional
public class UserInfoServiceImpl implements IUserInfoService {
	@Autowired
	private IUserInfoMapper userInfoMapper=null;
	@Override
	public void add(UserInfoModel userinfo) throws Exception {
		userInfoMapper.add(userinfo);

	}

	@Override
	public void modify(UserInfoModel userinfo) throws Exception {
		userInfoMapper.modify(userinfo);

	}

	@Override
	public void delete(UserInfoModel userinfo) throws Exception {
		userInfoMapper.delete(userinfo);

	}

	@Override
	public List<UserInfoModel> selsetListByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoModel getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
