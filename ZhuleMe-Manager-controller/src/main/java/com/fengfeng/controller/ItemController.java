package com.fengfeng.controller;

import com.fengfeng.common.pojo.EUIResult;
import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.common.utils.HttpClientUtil;
import com.fengfeng.pojo.TbItem;
import com.fengfeng.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lz on 2016/6/2.
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;
    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        TbItem tbItem=itemService.getItemById(itemId);
        return tbItem;
    }
    @RequestMapping("/item/list")
    @ResponseBody
    public EUIResult getItemList(Integer page,Integer rows){
        return itemService.getItemList(page,rows);
    }
    @RequestMapping(value = "/item/save",method = RequestMethod.POST)
    @ResponseBody
    public FengfengResult createItem(TbItem item,String desc,String itemParams){
        FengfengResult result=itemService.createItem(item, desc, itemParams);
        HttpClientUtil.doGet("http://123.206.13.239:8083/search" + "/add/" + item.getId());
        return result;
    }
}
