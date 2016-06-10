package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * Created by lz on 2016/6/7.
 */
public interface PictureService {
    Map uploadPicture(MultipartFile uploadFile) ;
}
