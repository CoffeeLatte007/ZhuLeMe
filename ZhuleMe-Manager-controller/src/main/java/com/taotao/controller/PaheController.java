package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**页面跳转controller
 * Created by lz on 2016/6/3.
 */
@Controller
public class PaheController {
    /**
     * 打开首页
     * @return
     */
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }
    @RequestMapping("/{page}")
    public String showpage(@PathVariable String page){
        return page;
    }
}
