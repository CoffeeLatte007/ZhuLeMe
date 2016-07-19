package com.fengfeng.portal.service;

import com.fengfeng.portal.model.SearchResult;

/**
 * Created by lz on 2016/7/19.
 */

public interface SearchService {
    public SearchResult search(String queryString,int page);
}
