package com.fengfeng.search.service;

import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.search.model.Item;
import com.fengfeng.search.model.SearchResult;

/**
 * Created by lz on 2016/7/18.
 */
public interface SearchService {

    SearchResult search(String queryString, int page, int rows) throws Exception;
    FengfengResult add(String  itemid);
}
