package com.hx.service;

import com.github.pagehelper.PageInfo;
import com.hx.entity.StatementLog;

public interface StatementLogService extends BaseService<StatementLog> {
    PageInfo<StatementLog> selectByTimes1(Integer pageIndex, Integer pageSize, String startDate);
}
