package com.fengfeng.portal.service.impl;

import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.common.utils.HttpClientUtil;
import com.fengfeng.portal.model.SearchResult;
import com.fengfeng.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lz on 2016/7/19.
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Value("${SEARCH_BASE_URL}")
    private String SEARCH_BASE_URL;

    @Override
    public SearchResult search(String queryString, int page) {
        // 调用taotao-search的服务
        //查询参数
        Map<String, String> param = new HashMap<>();
        param.put("q", queryString);
        param.put("page", page + "");
        try {
            //调用服务
            String json = HttpClientUtil.doGet(SEARCH_BASE_URL, param);
            //把字符串转换成java对象
            FengfengResult fengfengResult = FengfengResult.formatToPojo(json, SearchResult.class);
            if (fengfengResult.getStatus() == 200) {
                SearchResult result = (SearchResult) fengfengResult.getData();
                return result;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}