package com.hx.service.Impl;

import com.hx.entity.Parameter;
import com.hx.entity.SystemParameters;
import com.hx.service.BaseService;
import com.hx.service.SPMapperService;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by admin on 2020/5/22.
 */
public class BaseServiceImpl {
    @Resource
    private SPMapperService spMapperService;

    //这是获取系统时间的方法
    public Date getSystemTime(){
        Date date = null;
        //这里是获取系统时间的地方
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        try {
             date = df.parse(df.format(new Date()));// new Date()为获取当前系统时间
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    //这是进行系统参数校验与转换的方法
    public String sysParameterCheck(Parameter code){
       /*
       1.根据系统参数的程序启动就已加载完成的特性，去取得相关的系统参数值
       2.根据业务表的相关字段属性与系统参数进行匹配
       3.如果匹配完成，则返回该参数的text值到界面
       4.如果匹配失败，则进行异常处理
       */
       //获取系统参数
        Map<String,Object> map = spMapperService.returnSysparameter();
        //与系统参数进行匹配
        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            if(key.equals(code.getField())){
               Map<String,String> value = (Map<String, String>) map.get(key);

                //遍历value
                Set<String> set1 = value.keySet();
                Iterator<String> iterator1 = set1.iterator();
                while (iterator1.hasNext()){
                    String key1 = iterator1.next();
                    if(key1.equals(code.getValue())){
                        //返回text值
                        return value.get(key1);
                    }
                }
            }
        }
        return null;
    }
}
