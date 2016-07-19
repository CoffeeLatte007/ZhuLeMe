package com.fengfeng.search.mapper;

import com.fengfeng.search.model.Item;

import java.util.List;

/**
 * Created by lz on 2016/7/18.
 */
public interface ItemMapper {
    List<Item> getItemList();
    Item getItemById(String itemId);
}
