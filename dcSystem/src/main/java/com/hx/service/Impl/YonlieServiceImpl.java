package com.hx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.mapper.BaseMapper;
import com.hx.service.YonlieService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/5/8.
 */
@Service
public abstract class YonlieServiceImpl<T> implements YonlieService<T> {
    public abstract BaseMapper<T> getMapper();

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        return getMapper().insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return getMapper().insertSelective(record);
    }

    @Override
    public T selectByPrimaryKey(Integer callId) {
        return (T) getMapper().selectByPrimaryKey(callId);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return getMapper().updateByPrimaryKey(record);
    }

    @Override
   public PageInfo<T> selectPage(Integer pageIndex, Integer pageSize, T t) {
       PageHelper.startPage(pageIndex,pageSize);
        List<T> list=getMapper().selectPage(t);
        PageInfo<T> pageInfo=new PageInfo<T>(list);
        return  pageInfo;
    }

    //获取当前时间形成字符串的方法，用于数据库插入时间
    @Override
    public  String getDatetoString(){
        Date date = new Date();//加入时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String dateString = dateFormat.format(date);
        return dateString;
    }
}
