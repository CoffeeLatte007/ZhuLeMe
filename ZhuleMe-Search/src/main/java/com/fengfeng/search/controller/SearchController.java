package com.fengfeng.search.controller;

import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.common.utils.ExceptionUtil;
import com.fengfeng.search.model.SearchResult;
import com.fengfeng.search.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lz on 2016/7/18.
 */
@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value="/query", method= RequestMethod.GET)
    @ResponseBody
    public FengfengResult search(@RequestParam("q")String queryString,
                               @RequestParam(defaultValue="1")Integer page,
                               @RequestParam(defaultValue="60")Integer rows) {
        //查询条件不能为空
        if (StringUtils.isBlank(queryString)) {
            return FengfengResult.build(400, "查询条件不能为空");
        }
        SearchResult searchResult = null;
        try {
            queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
            searchResult = searchService.search(queryString, page, rows);
        } catch (Exception e) {
            e.printStackTrace();
            return FengfengResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return FengfengResult.ok(searchResult);
    }
    @RequestMapping(value = "/add/{itemId}")
    @ResponseBody
    public FengfengResult addItem(@PathVariable("itemId") String itemId){
        if (StringUtils.isBlank(itemId)) {
            return FengfengResult.build(400, "查询条件不能为空");
        }
        return searchService.add(itemId);
    }
}