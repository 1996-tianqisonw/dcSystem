package com.hx.service;

import com.hx.entity.cookDetail;

/**
 * Created by admin on 2020/5/25.
 */
public interface cookDetailService extends BaseService<cookDetail> {
    int updateByPrimaryKey(cookDetail record,String mark);
}
