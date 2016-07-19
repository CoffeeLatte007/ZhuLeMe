package com.fengfeng.service;

import com.fengfeng.common.pojo.EUIResult;
import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.pojo.TbContent;

import java.util.List;

/**
 * Created by lz on 2016/6/14.
 */
public interface ContentService {
    public EUIResult getContentList(Integer page,Integer rows,Long categoryId);
    public FengfengResult insertContent(TbContent content);
    public List<TbContent> getContentListById(long contentCid);
}
