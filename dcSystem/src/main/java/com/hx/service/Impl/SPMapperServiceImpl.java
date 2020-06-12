package com.hx.service.Impl;

import com.hx.entity.SystemParameters;
import com.hx.entity.Table;
import com.hx.mapper.SystemParametersMapper;
import com.hx.mapper.TableMapper;
import com.hx.service.SPMapperService;
import com.hx.util.Erweima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

import static com.hx.util.Erweima.create;

/**
 * Created by admin on 2020/5/26.
 */
@Service
public class SPMapperServiceImpl implements SPMapperService{

    @Autowired
    private SystemParametersMapper systemParametersMapper;

    @Autowired
    private TableMapper tableMapper;

    static Map<String,Object> sysParMap = new HashMap<>();

    //这个方法是查询系统参数并进行map的包装
    @Override
    public Map<String, Object> selectSP() {
        Map<String,Object> map = new HashMap<>();
        Map<String,String> valueMap = null;
        List<SystemParameters> systemParametersList = systemParametersMapper.selectAll();
        for(SystemParameters systemParameter:systemParametersList){
            if(null==(map.get(systemParameter.getStField()))){
                valueMap = new LinkedHashMap<>();
                valueMap.put(systemParameter.getStValue(),systemParameter.getStText());
                map.put(systemParameter.getStField(),valueMap);
            }else{
                valueMap = (Map<String,String>)map.get(systemParameter.getStField());
                valueMap.put(systemParameter.getStValue(),systemParameter.getStText());
            }
        }
        return map;
    }

    //该方法表示在程序加载时就获取数据。
    @PostConstruct  //表示在构造方法调用后执行
    public void select(){
        Map<String, Object> map = selectSP();
        sysParMap = map;
    }

    //该方法表示生成二维码图片
    public void generationPice() throws Exception {
        //这是查询数据库的字符串,把它们遍历出来放入生成器。
        List<Table> table = tableMapper.selectTableAll();
        String path = "E:/work/repo/git-repo/dcSystem/src/main/webapp/erweima";
        for(Table tab : table){
            //这是生成二维码的图片
            Erweima.create(tab.getDcQrcode(),tab.getDcId(),path);
        }
    }

    @Override
    public Map<String,Object> returnSysparameter(){
        Set<String> set = sysParMap.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String io = iterator.next();
            Object value = sysParMap.get(io);
        }
        return sysParMap;
    }

}
