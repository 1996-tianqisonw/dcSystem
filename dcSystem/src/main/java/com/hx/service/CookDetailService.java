package com.hx.service;

import com.hx.entity.CookDetail;

/**
 * Created by admin on 2020/5/25.
 */
public interface CookDetailService extends BaseService<CookDetail> {
    int updateByPrimaryKey(CookDetail record, String mark);
}
