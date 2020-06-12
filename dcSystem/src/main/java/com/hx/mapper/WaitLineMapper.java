package com.hx.mapper;

import com.hx.entity.WaitLine;


public interface WaitLineMapper extends BaseMapper<WaitLine> {
    public WaitLine selectLast();
}