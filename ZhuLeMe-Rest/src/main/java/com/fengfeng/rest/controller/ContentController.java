package com.fengfeng.rest.controller;

import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.common.utils.ExceptionUtil;
import com.fengfeng.pojo.TbContent;
import com.fengfeng.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lz on 2016/6/15.
 */
@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    ContentService contentService;
    @RequestMapping("/list/{contentCategoryId}")
    @ResponseBody
    public FengfengResult getContentList(@PathVariable Long contentCategoryId){
        try {
            List<TbContent> list = contentService.getContentListById(contentCategoryId);
            return FengfengResult.ok(list);
        }catch (Exception e){
            return FengfengResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }
}
