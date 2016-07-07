package com.taotao.controller;

import com.taotao.common.pojo.EUIResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ItemParamService;
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
    public TaotaoResult queryCatalogById(@PathVariable long cid) throws Exception{
        //根据分类id查询列表
        TaotaoResult result=itemParamService.getItemParamByCid(cid);
        return result;
    }
    @RequestMapping("save/{cid}")
    @ResponseBody
    public TaotaoResult saveItemParam(@PathVariable Long cid,String paramData) throws Exception{
        TaotaoResult result=itemParamService.insertItemParam(cid,paramData);
        return result;
    }
    @RequestMapping("/list")
    @ResponseBody
    public EUIResult getItemList(Integer page,Integer rows){
        return itemParamService.getItemList(page,rows);
    }

}
