package com.fengfeng.controller;

import com.fengfeng.common.pojo.EUTreeNode;
import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lz on 2016/6/13.
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;
    @RequestMapping("/list")
    @ResponseBody
    public List<EUTreeNode> getContentCatList(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        List<EUTreeNode> list=contentCategoryService.getCategoryList(parentId);
        return list;
    }
    @RequestMapping("/create")
    @ResponseBody
    public FengfengResult createContentCategory(Long parentId,String name){
        FengfengResult result=contentCategoryService.insertContentCategory(parentId,name);
        return result;
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public FengfengResult deleteContentCategory(Long parentId,Long id){
        System.out.println(parentId+"..."+id);
        FengfengResult result=contentCategoryService.deleteContentCategory(parentId,id);
        return result;
    }
}
