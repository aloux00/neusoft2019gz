package com.neusoft.wuyemis.admin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuyemis.admin.model.UserInfoModel;
import com.neusoft.wuyemis.admin.service.IUserInfoService;
import com.neusoft.wuyemis.message.ResultMessage;

@RestController
@RequestMapping(value="/userinfo")
public class UserInfoController {
	private IUserInfoService userInfoService=null;
	//增加
	@RequestMapping("/add")
	public ResultMessage<UserInfoModel>add(UserInfoModel userinfo) throws Exception {
		userInfoService.add(userinfo);
		return new ResultMessage<UserInfoModel>("OK","增加成功");
	}
    //修改
	@PostMapping("/modify")
	public ResultMessage<UserInfoModel>modify(UserInfoModel  userinfo) throws Exception{
		userInfoService.modify(userinfo);
		return new ResultMessage<UserInfoModel>("OK","修改成功");
	}
	//删除
	@PostMapping("/delete")
	public ResultMessage<UserInfoModel>delete(UserInfoModel  userinfo) throws Exception{
		userInfoService.modify(userinfo);
		return new ResultMessage<UserInfoModel>("OK","删除成功");
	}
	
}

