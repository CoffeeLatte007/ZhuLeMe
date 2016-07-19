package com.fengfeng.controller;

import com.fengfeng.common.pojo.EUIResult;
import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lz on 2016/6/11.
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
    @Autowired
    ItemParamService itemParamService;
    @RequestMapping("query/itemcatid/{cid}")
    @ResponseBody
    public FengfengResult queryCatalogById(@PathVariable long cid) throws Exception{
        //根据分类id查询列表
        FengfengResult result=itemParamService.getItemParamByCid(cid);
        return result;
    }
    @RequestMapping("save/{cid}")
    @ResponseBody
    public FengfengResult saveItemParam(@PathVariable Long cid,String paramData) throws Exception{
        FengfengResult result=itemParamService.insertItemParam(cid,paramData);
        return result;
    }
    @RequestMapping("/list")
    @ResponseBody
    public EUIResult getItemList(Integer page,Integer rows){
        return itemParamService.getItemList(page,rows);
    }

}
