package com.taotao.service;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by lz on 2016/6/7.
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_USERPASSWD}")
    private String FTP_USERPASSWD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;
    @Override
    public Map uploadPicture(MultipartFile uploadFile)  {
        //生成新的文件名
        String oldName = uploadFile.getOriginalFilename();
        //生成新文件名
//        UUID.randomUUID();
        String newName=IDUtils.genImageName();
        newName = newName + oldName.substring(oldName.lastIndexOf("."));
        //图片上
        Map resultMap = new HashMap<>();
        String imagePath=new DateTime().toString("/yyyy/MM/dd");
        try {
            boolean result =FtpUtil.uploadFile(FTP_ADDRESS,FTP_PORT,FTP_USERNAME,FTP_USERPASSWD,FTP_BASE_PATH,imagePath,newName,uploadFile.getInputStream());
            if(!result){
                resultMap.put("error",1);
                resultMap.put("message","文件上传失败");
                return resultMap;
            }
            resultMap.put("error",0);
            resultMap.put("url",IMAGE_BASE_URL+imagePath+"/"+newName);
            return resultMap;
        } catch (IOException e) {
            resultMap.put("error",1);
            resultMap.put("message","文件上传发生异常");
            e.printStackTrace();
            return resultMap;
        }

    }
}
