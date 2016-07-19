package com.fengfeng.controller;

import com.fengfeng.common.pojo.EUITreeNode;
import com.fengfeng.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *商品分类管理
 * Created by lz on 2016/6/4.
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;
    @RequestMapping("list")
    @ResponseBody
    public List<EUITreeNode> getItemCatList(@RequestParam(value = "id",defaultValue = "0")Long parentId){
        return itemCatService.getItemCatList(parentId);
    }
}
