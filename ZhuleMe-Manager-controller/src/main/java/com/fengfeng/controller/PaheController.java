package com.fengfeng.controller;

import org.apache.ibatis.annotations.Param;
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
//    @RequestMapping("/lz")
//    public String my(@Param("cc")String cc){
//        System.out.println(cc);
//        return null;
//    }
//    @RequestMapping("/lz")
//    public String my1(@Param("cc")String cc,@Param("flag")String f){
//        System.out.println(f+" "+cc);
//        return null;
//    }
    @RequestMapping("/{page}")
    public String showpage(@PathVariable String page){
        return page;
    }
}
