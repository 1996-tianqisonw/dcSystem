package com.hx.service;

import com.hx.entity.WaitOn;

/**
 * Created by Administrator on 2020/5/17.
 */
public interface WaitOnService extends YonlieService<WaitOn> {
    public int updateOn_state(int id, String state);

    public boolean WaitOnorOff(String dp_id);
}
