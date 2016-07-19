package com.fengfeng.service;

import com.fengfeng.common.pojo.EUITreeNode;

import java.util.List;

/**
 * Created by lz on 2016/6/4.
 */
public interface ItemCatService {
    List<EUITreeNode> getItemCatList(long parentId);
}
