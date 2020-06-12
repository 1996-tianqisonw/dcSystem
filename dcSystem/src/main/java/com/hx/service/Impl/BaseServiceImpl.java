package com.hx.service.Impl;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Parameter;
import com.hx.mapper.*;
import com.hx.service.BaseService;
import com.hx.service.SPMapperService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by admin on 2020/5/22.
 */
public class BaseServiceImpl<T> implements BaseService<T>{
    private BaseMapper<T> baseMapper;
    @Autowired
    CookingMapper cookingMapper;
    @Autowired
    TableStateMapper tableStateMapper;
    @Autowired
    TableMapper tableMapper;
    @Autowired
    CookDetailMapper cookDetailMapper;
    @Resource
    private SPMapperService spMapperService;
    @Autowired
    CategoriesMapper categoriesMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    SpecificationMapper specificationMapper;
    //在构建父类完成后，baseMapper需要有对应的相关子Mapper的对象作为引用
    @PostConstruct//在构造方法后，初始数据的处理
    private void initBaseMapper() throws Exception{
        //完成以下逻辑，需要对研发本身进行命名与使用规范
        //this关键字指对象本身，这里指的是调用此方法的实现类（子类）
        System.out.println("=======this :"+this);
        System.out.println("=======父类基本信息："+this.getClass().getSuperclass());
        System.out.println("=======父类和泛型的信息："+this.getClass().getGenericSuperclass());

        ParameterizedType type =(ParameterizedType) this.getClass().getGenericSuperclass();
        //获取第一个参数的class
        Class clazz = (Class)type.getActualTypeArguments()[0];//SysUser
        System.out.println("=======class:"+clazz);
        //转化为属性名（相关的Mapper子类的引用名） sysUserMapper
        String localField = clazz.getSimpleName().substring(0,1).toLowerCase()+clazz.getSimpleName().substring(1)+"Mapper";
        System.out.println("=======localField:"+localField);
        //getDeclaredField:可以使用于包括私有、默认、受保护、公共字段，但不包括继承的字段
        Field field=this.getClass().getSuperclass().getDeclaredField(localField);
        System.out.println("=======field:"+field);
        System.out.println("=======field对应的对象:"+field.get(this));
        Field baseField = this.getClass().getSuperclass().getDeclaredField("baseMapper");

        System.out.println("=======baseField:"+baseField);
        System.out.println("=======baseField对应的对象:"+baseField.get(this));
        //field.get(this)获取当前this的field字段的值。例如：Supplier对象中，baseMapper所指向的对象为其子类型SupplierMapper对象，子类型对象已被spring实例化于容器中
        baseField.set(this, field.get(this));
        System.out.println("========baseField对应的对象:"+baseMapper);
    }

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

    @Override
    public <K> int deleteByPrimaryKey(K dcId) {
        return 0;
    }

    @Override
    public int insert(T record) throws Exception {
        return 0;
    }

    @Override
    public int insertSelective(T record) {
        return 0;
    }

    @Override
    public <K> T selectByPrimaryKey(K dcId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return 0;
    }

    @Override
    public PageInfo<T> selectServiceAll(T table, Integer pageIndex, Integer pageSize) {
        return null;
    }
}
