package com.hx.service;

import com.github.pagehelper.PageInfo;


/**
 * Created by Administrator on 2020/5/8.
 */
public interface YonlieService<T> {
    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer callId);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    PageInfo<T> selectPage(Integer pageIndex, Integer pageSize, T t);

    public  String getDatetoString();
}
