package com.fengfeng.service;

import com.fengfeng.common.pojo.EUIResult;
import com.fengfeng.common.pojo.FengfengResult;

/**
 * Created by lz on 2016/6/11.
 */
public interface ItemParamService {
    FengfengResult getItemParamByCid(long cid);
    FengfengResult insertItemParam(long cid,String itemParam);

    EUIResult getItemList(Integer page, Integer rows);
}
