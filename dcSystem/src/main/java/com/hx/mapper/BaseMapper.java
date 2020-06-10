package com.hx.mapper;

import com.hx.entity.Table;

import java.util.List;

/**
 * Created by admin on 2020/5/21.
 */
public interface BaseMapper<T> {
   <K> int deleteByPrimaryKey(K dcId);

    int insert(T record);

    int insertSelective(T record);

   <K> T selectByPrimaryKey(K dcId);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    List<T> selectAll(T table);
}
