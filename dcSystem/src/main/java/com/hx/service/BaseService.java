package com.hx.service;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Table;

/**
 * Created by admin on 2020/5/21.
 */
public interface BaseService<T> {
    <K> int deleteByPrimaryKey(K dcId);

    int insert(T record);

    int insertSelective(T record);

    <K> T selectByPrimaryKey(K dcId);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    PageInfo<T> selectServiceAll(T table, Integer pageIndex, Integer pageSize);
}
