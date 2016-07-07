package com.taotao.controller;

import com.taotao.common.pojo.EUIResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lz on 2016/6/14.
 */
@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    ContentService contentService;
    @RequestMapping("/query/list")
    @ResponseBody
    public EUIResult getUIList(Integer page,Integer rows,Long categoryId){
        return contentService.getContentList(page,rows,categoryId);
    }
    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult insertContent(TbContent content){
        TaotaoResult result = contentService.insertContent(content);
        return result;
    }
    @RequestMapping("/list/{contentCategoryId}")
    @ResponseBody
    public TaotaoResult getContentList(@PathVariable Long contentCategoryId){
        try {
            List<TbContent> list = contentService.getContentListById(contentCategoryId);
            return TaotaoResult.ok(list);
        }catch (Exception e){
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }
}
