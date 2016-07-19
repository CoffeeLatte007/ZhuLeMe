package com.fengfeng.rest.service;

import com.fengfeng.common.pojo.FengfengResult;

public interface ItemService {

	FengfengResult getItemBaseInfo(long itemId);
	FengfengResult getItemDesc(long itemId);
	FengfengResult getItemParam(long itemId);
}
