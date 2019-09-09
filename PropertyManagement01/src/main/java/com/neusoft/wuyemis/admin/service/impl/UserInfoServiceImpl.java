package com.neusoft.wuyemis.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.neusoft.wuyemis.admin.mapper.IUserInfoMapper;
import com.neusoft.wuyemis.admin.model.UserInfoModel;
import com.neusoft.wuyemis.admin.service.IUserInfoService;
@Service
@Transactional(rollbackFor = Exception.class)
public class UserInfoServiceImpl implements IUserInfoService {
	
	@Autowired
	private IUserInfoMapper userInfoMapper=null;


	
	
	@Override
	public void register(UserInfoModel userinfo) throws Exception {
	

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


		return null;
	}

	@Override
	public UserInfoModel getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
