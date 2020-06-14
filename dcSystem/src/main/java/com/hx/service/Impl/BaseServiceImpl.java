package com.hx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.*;
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
import java.util.*;

/**
 * Created by admin on 2020/5/22.
 */
public class BaseServiceImpl<T> implements BaseService<T>{
    BaseMapper<T> baseMapper;

    @Autowired
    TableMapper tableMapper;
    @Autowired
    TableStateMapper tableStateMapper;
    @Autowired
    CookDetailMapper cookDetailMapper;
    @Autowired
    CookingMapper cookingMapper;
    @Resource
    private SPMapperService spMapperService;
    @Autowired
    CategoriesMapper categoriesMapper;

    @Autowired
    SpecificationMapper specificationMapper;

    @Autowired
    BusOrderDetailsMapper busOrderDetailsMapper;

    @Autowired
    BusOrderMapper busOrderMapper;

    @Autowired
    BusRefundDetailsMapper busRefundDetailsMapper;

    @Autowired
    BusRefundMapper busRefundMapper;

    @Autowired
    BusShopCartMapper busShopCartMapper;

    @Autowired
    DcKitchencookingMapper dcKitchencookingMapper;

    @Autowired
    DcTablemanagementMapper dcTablemanagementMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    SysParamMapper sysParamMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RolemeMapper rolemeMapper;
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    UsersroMapper usersroMapper;
    @Autowired
    StatementMapper statementMapper;

    @Autowired
    StatementLogMapper statementLogMapper;

    //在构建父类完成后，baseMapper需要有对应的相关子Mapper的对象作为引用
    @PostConstruct//在构造方法后，初始数据的处理
    private void initBaseMapper() throws Exception{
        //完成以下逻辑，需要对研发本身进行命名与使用规范
        //this关键字指对象本身，这里指的是调用此方法的实现类（子类）
        ParameterizedType type =(ParameterizedType) this.getClass().getGenericSuperclass();
        //获取第一个参数的class
        Class clazz = (Class)type.getActualTypeArguments()[0];//SysUser
        //转化为属性名（相关的Mapper子类的引用名） sysUserMapper
        String localField = clazz.getSimpleName().substring(0,1).toLowerCase()+clazz.getSimpleName().substring(1)+"Mapper";
        //getDeclaredField:可以使用于包括私有、默认、受保护、公共字段，但不包括继承的字段
        Field field=this.getClass().getSuperclass().getDeclaredField(localField);
        Field baseField = this.getClass().getSuperclass().getDeclaredField("baseMapper");
        //field.get(this)获取当前this的field字段的值。例如：Supplier对象中，baseMapper所指向的对象为其子类型SupplierMapper对象，子类型对象已被spring实例化于容器中
        baseField.set(this, field.get(this));

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
    public int insert(T record)throws Exception{
        return baseMapper.insert(record);
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

    //分页
    @Override
    public PageInfo<T> selectPage(T entity, Integer pageIndex, Integer pageSize) {
        //startPage：设置的分页查询条件，它只起作用于接下来的第一条执行的sql
        PageHelper.startPage(pageIndex, pageSize);
        //查询数据
        List<T> list = baseMapper.selectPage(entity);
        //封装查询信息，便于使用
        PageInfo<T> pageInfo = new PageInfo<T>(list);

        return pageInfo;
    }

    //批量添加订单详细
    @Override
    public int insertBatch(List<T> record) {
        return baseMapper.insertBatch(record);
    }

    //查询需要的字段,没入参
    @Override
    public List<T> selectList() {
        return baseMapper.selectList();
    }

    //系统参数
    @Override
    public Map<String, Object> loadSysParam() {
        //用来保存系统所有字段的参数
        Map<String, Object> sysParamMap = new HashMap<String, Object>();
        //用来存放某个字段的参数
        Map<String, Object> fieldMap = null;

        List<SysParam> sysParams = sysParamMapper.selectSysParamList();
        for (SysParam sysParam : sysParams) {
            if(null==sysParamMap.get(sysParam.getSysParamField())){
                //系统参数的map没有相关字段的map,就创建一个
                fieldMap = new LinkedHashMap<String, Object>();
                //把对应的key和value(显示文本)存放字段的map里
                fieldMap.put(sysParam.getSysParamValue(), sysParam.getSysParamText());
                //把字段的map存到系统参数的map里，下次再取时就存在字段map了
                sysParamMap.put(sysParam.getSysParamField(), fieldMap);
            }else{
                //系统参数的map已经有相关字段的map,就直接使用
                fieldMap =(Map<String, Object>) sysParamMap.get(sysParam.getSysParamField());
                //System.out.println("fieldMap = "+fieldMap);
                //把对应的key和value(显示文本)存放字段的map里
                fieldMap.put(sysParam.getSysParamValue(), sysParam.getSysParamText());
                // System.out.println("fieldMap.put = "+fieldMap);
                //把字段的map存到系统参数的map里，下次再取时就存在字段map了
                sysParamMap.put(sysParam.getSysParamField(), fieldMap);
            }
        }
        return sysParamMap;
    }
}
