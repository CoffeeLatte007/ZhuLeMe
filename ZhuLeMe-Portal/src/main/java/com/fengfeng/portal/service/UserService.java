package com.fengfeng.portal.service;

import com.fengfeng.pojo.TbUser;

public interface UserService {

	TbUser getUserByToken(String token);
}
