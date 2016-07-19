package com.fengfeng.portal.controller;

import com.fengfeng.portal.model.SearchResult;
import com.fengfeng.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;

/**
 * Created by lz on 2016/7/19.
 */
@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping("/search")
    public String search(@RequestParam(value = "q")String queryString, @RequestParam(defaultValue="1")Integer page, ModelMap model) {
        if (queryString != null) {
            try {
                queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else {
            queryString="小米5";
        }
        SearchResult searchResult = searchService.search(queryString, page);
        //向页面传递参数
        model.put("query", queryString);
        model.put("totalPages", searchResult.getPageCount());
        model.put("itemList", searchResult.getItemList());
        model.put("page", page);

        return "search";

    }
}