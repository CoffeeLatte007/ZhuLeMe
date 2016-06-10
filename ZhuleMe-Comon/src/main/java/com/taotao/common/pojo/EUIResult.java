package com.taotao.common.pojo;

import java.util.List;

/**
 * 给easui用的
 * Created by lz on 2016/6/4.
 */
public class EUIResult {
    private long total;
    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
