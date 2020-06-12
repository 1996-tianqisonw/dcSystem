package com.hx.service;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Table;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2020/5/21.
 */
public interface BaseService<T> {
    <K> int deleteByPrimaryKey(K dcId);

    int insert(T record) throws Exception;

    int insertSelective(T record);

    <K> T selectByPrimaryKey(K dcId);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    PageInfo<T> selectServiceAll(T table, Integer pageIndex, Integer pageSize);

    //分页
    public PageInfo<T> selectPage(T entity, Integer pageIndex, Integer pageSize);

    //批量添加订单详细
    int insertBatch(List<T> record);

    //查询需要的字段,没入参
    List<T> selectList();

    //加载系统参数方法
    public Map<String, Object> loadSysParam();
}
