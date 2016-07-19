package com.fengfeng.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.portal.model.CartItem;

public interface CartService {

	FengfengResult addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response);
	List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);
	FengfengResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
}
