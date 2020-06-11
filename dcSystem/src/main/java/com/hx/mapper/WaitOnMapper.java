package com.hx.mapper;

import com.hx.entity.WaitOn;

public interface WaitOnMapper extends BaseMapper<WaitOn> {
    public WaitOn WaitOnorOff(String dp_id);
}