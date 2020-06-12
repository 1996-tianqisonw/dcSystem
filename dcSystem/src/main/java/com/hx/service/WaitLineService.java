package com.hx.service;

import com.hx.entity.WaitLine;


/**
 * Created by Administrator on 2020/5/17.
 */
public interface WaitLineService extends YonlieService<WaitLine> {
    public WaitLine selectLast();

    public int ReloadPx();

    public int updateByPrimaryKeySelective(int id, String state);
}
