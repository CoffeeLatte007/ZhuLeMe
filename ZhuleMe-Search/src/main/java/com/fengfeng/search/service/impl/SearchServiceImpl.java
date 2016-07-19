package com.fengfeng.search.service.impl;

import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.common.utils.ExceptionUtil;
import com.fengfeng.search.dao.SearchDao;
import com.fengfeng.search.mapper.ItemMapper;
import com.fengfeng.search.model.Item;
import com.fengfeng.search.model.SearchResult;
import com.fengfeng.search.service.SearchService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by lz on 2016/7/18.
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchDao searchDao;
    @Autowired
    private SolrServer solrServer;
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public SearchResult search(String queryString, int page, int rows) throws Exception {
        //创建查询对象
        SolrQuery query = new SolrQuery();
        //设置查询条件
        query.setQuery(queryString);
        //设置分页
        query.setStart((page - 1) * rows);
        query.setRows(rows);
        //设置默认搜素域
        query.set("df", "item_keywords");
        //设置高亮显示
        query.setHighlight(true);
        query.addHighlightField("item_title");
        query.setHighlightSimplePre("<em style=\"color:red\">");
        query.setHighlightSimplePost("</em>");
        //执行查询
        SearchResult searchResult = searchDao.search(query);
        //计算查询结果总页数
        long recordCount = searchResult.getRecordCount();
        long pageCount = recordCount / rows;
        if (recordCount % rows > 0) {
            pageCount++;
        }
        searchResult.setPageCount(pageCount);
        searchResult.setCurPage(page);

        return searchResult;
    }

    @Override
    public FengfengResult add(String  itemId) {

        try {

            //查询商品列表
            Item item=itemMapper.getItemById(itemId);
            //把商品信息写入索引库

                //创建一个SolrInputDocument对象
                SolrInputDocument document = new SolrInputDocument();
                document.setField("id", item.getId());
                document.setField("item_title", item.getTitle());
                document.setField("item_sell_point", item.getSell_point());
                document.setField("item_price", item.getPrice());
                document.setField("item_image", item.getImage());
                document.setField("item_category_name", item.getCategory_name());
                document.setField("item_desc", item.getItem_des());
                //写入索引库
                solrServer.add(document);

            //提交修改
            solrServer.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return FengfengResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return FengfengResult.ok();
        }

}
