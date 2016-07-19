package com.fengfeng.service;

import com.fengfeng.common.pojo.EUTreeNode;
import com.fengfeng.common.pojo.FengfengResult;

import java.util.List;

/**
 * Created by lz on 2016/6/13.
 */
public interface ContentCategoryService {
    public List<EUTreeNode> getCategoryList(long parentId);
    public FengfengResult insertContentCategory(long parentId,String name);

    public FengfengResult deleteContentCategory(Long parentId, Long id);
}
