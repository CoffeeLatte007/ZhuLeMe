package com.taotao.service;

import com.taotao.common.pojo.EUIResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * Created by lz on 2016/6/11.
 */
public interface ItemParamService {
    TaotaoResult getItemParamByCid(long cid);
    TaotaoResult insertItemParam(long cid,String itemParam);

    EUIResult getItemList(Integer page, Integer rows);
}
