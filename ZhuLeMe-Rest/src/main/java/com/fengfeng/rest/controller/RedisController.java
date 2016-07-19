package com.fengfeng.rest.controller;

import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.rest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lz on 2016/6/16.
 */
@Controller
@RequestMapping("/cache/sync")
public class RedisController {
    @Autowired
    private RedisService redisService;
    @RequestMapping("/content/{contentCid}")
    @ResponseBody
    public FengfengResult contentCacheSync(@PathVariable Long contentCid){
        FengfengResult result=redisService.syncContent(contentCid);
        return result;
    }
}
