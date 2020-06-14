package com.hx.service;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Statement;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by huangyu on 2020/6/1.
 */
public interface StatementService extends BaseService<Statement> {
    //根据店铺id和日期统计订单
    List<Statement> selectByOrder(LocalDate countDate, String shopId);
    //根据日期统计订单
    List<Statement> selectByOrder2(LocalDate countDate);
    //根据店铺id和日期统计退单
    List<Statement> selectByReturn(LocalDate countDate, String shopId);
    //根据日期统计退单
    List<Statement> selectByReturn2(LocalDate countDate);
    //查询分页报表
    PageInfo<Statement> selectByTimes(Integer pageIndex, Integer pageSize, String startDate, String endDate);

}