package com.fengfeng.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.rest.service.ItemService;


@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/info/{itemId}")
	@ResponseBody
	public FengfengResult getItemBaseInfo(@PathVariable Long itemId) {
		FengfengResult result = itemService.getItemBaseInfo(itemId);
		return result;
	}
	
	@RequestMapping("/desc/{itemId}")
	@ResponseBody
	public FengfengResult getItemDesc(@PathVariable Long itemId) {
		FengfengResult result = itemService.getItemDesc(itemId);
		return result;
	}
	
	@RequestMapping("/param/{itemId}")
	@ResponseBody
	public FengfengResult getItemParam(@PathVariable Long itemId) {
		FengfengResult result = itemService.getItemParam(itemId);
		return result;
	}
}
