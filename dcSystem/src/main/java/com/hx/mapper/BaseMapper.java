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

    List<T> selectPage(T t);

 //批量添加订单详细
 int insertBatch(List<T> record);

 //查询需要的字段,没入参
 List<T> selectList();

 //查系统参数
 List<T> selectSysParamList();
}
