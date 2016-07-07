package com.taotao.controller;

import com.taotao.common.pojo.EUITreeNode;
import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ContentCategoryService;
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
    public TaotaoResult createContentCategory(Long parentId,String name){
        TaotaoResult result=contentCategoryService.insertContentCategory(parentId,name);
        return result;
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult deleteContentCategory(Long parentId,Long id){
        System.out.println(parentId+"..."+id);
        TaotaoResult result=contentCategoryService.deleteContentCategory(parentId,id);
        return result;
    }
}
