package com.taotao.service;

import com.taotao.common.pojo.EUIResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * Created by lz on 2016/6/2.
 */
public interface ItemService {
    TbItem getItemById(long itenid);
    EUIResult getItemList(int page,int rows);
    TaotaoResult createItem(TbItem item, String desc, String itemParams);
}
