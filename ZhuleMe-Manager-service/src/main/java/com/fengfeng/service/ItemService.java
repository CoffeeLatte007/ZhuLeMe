package com.fengfeng.service;

import com.fengfeng.common.pojo.EUIResult;
import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.pojo.TbItem;

/**
 * Created by lz on 2016/6/2.
 */
public interface ItemService {
    TbItem getItemById(long itenid);
    EUIResult getItemList(int page,int rows);
    FengfengResult createItem(TbItem item, String desc, String itemParams);
}
