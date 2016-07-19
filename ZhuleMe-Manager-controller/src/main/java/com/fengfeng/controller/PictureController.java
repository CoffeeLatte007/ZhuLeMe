package com.fengfeng.controller;

import com.fengfeng.common.utils.JsonUtils;
import com.fengfeng.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 上传图片
 * Created by lz on 2016/6/7.
 */
@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;
    @RequestMapping("/pic/upload")
    @ResponseBody
    public String pictureUpload(MultipartFile uploadFile){
        Map res=pictureService.uploadPicture(uploadFile);
        String json = JsonUtils.objectToJson(res);
        return json;
    }
}
