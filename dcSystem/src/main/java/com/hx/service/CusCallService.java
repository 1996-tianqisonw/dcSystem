package com.hx.service;

import com.hx.entity.CusCall;

/**
 * Created by Administrator on 2020/5/17.
 */
public interface CusCallService extends YonlieService<CusCall> {
    public int updateByPrimaryKeySelective(String[] ids);
}
