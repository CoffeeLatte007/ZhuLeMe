package com.taotao.portal.controller;

import com.taotao.portal.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lz on 2016/6/12.
 */
@Controller
public class PageController {
    @Autowired
    ContentService contentService;
    @RequestMapping("/index")
    public String showIndex(Model model) throws Exception{
        model.addAttribute("ad1",contentService.getContentList());
        return "index";
    }
}
