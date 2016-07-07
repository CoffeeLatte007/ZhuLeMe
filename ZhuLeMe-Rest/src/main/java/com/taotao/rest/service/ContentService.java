package com.taotao.rest.service;

import com.taotao.pojo.TbContent;

import java.util.List;

/**
 * Created by lz on 2016/6/15.
 */
public interface ContentService {
    public List<TbContent> getContentListById(long contentCid);
}
