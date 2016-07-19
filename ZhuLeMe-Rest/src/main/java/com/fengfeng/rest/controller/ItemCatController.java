package com.fengfeng.rest.controller;

import com.fengfeng.rest.pojo.ItemCatResult;
import com.fengfeng.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lz on 2016/6/12.
 */
@Controller
public class ItemCatController {
    @Autowired
    ItemCatService itemCatService;
    @RequestMapping("/itemcat/all")
    @ResponseBody
    public MappingJacksonValue queryAll(String callback) throws Exception{
        //查询分类列表
        ItemCatResult result=itemCatService.queryAllCategory();
        MappingJacksonValue jacksonValue=new MappingJacksonValue(result);
        jacksonValue.setJsonpFunction(callback);
        return jacksonValue;
    }
}
