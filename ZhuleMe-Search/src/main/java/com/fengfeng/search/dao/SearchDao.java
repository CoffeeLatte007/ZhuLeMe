package com.fengfeng.search.dao;

import com.fengfeng.search.model.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;

/**
 * Created by lz on 2016/7/18.
 */
public interface SearchDao {
    public SearchResult search(SolrQuery query)throws Exception;
}
