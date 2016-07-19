package com.fengfeng.search.controller;

import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.search.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lz on 2016/7/18.
 */
@Controller
@RequestMapping("/manager")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @RequestMapping("/importall")
    @ResponseBody
    public FengfengResult importAllItems(){
        FengfengResult result=itemService.importAllItems();
        return result;
    }
}
