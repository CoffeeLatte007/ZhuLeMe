package com.fengfeng.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.pojo.TbUser;

public interface UserService {

	FengfengResult checkData(String content, Integer type);
	FengfengResult createUser(TbUser user);
	FengfengResult userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response);
	FengfengResult getUserByToken(String token);

	FengfengResult userLoginout(HttpServletRequest request, HttpServletResponse response);
}
