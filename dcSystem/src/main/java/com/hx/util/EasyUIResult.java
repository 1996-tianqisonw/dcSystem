package com.hx.util;

import java.util.List;

/**
 * Created by zhh on 2019-04-25.
 */
public class EasyUIResult<T> {

    private Long total;
    private List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
