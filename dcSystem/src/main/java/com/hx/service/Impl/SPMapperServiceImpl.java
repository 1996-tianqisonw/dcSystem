package com.hx.service.Impl;

import com.hx.entity.SysParam;
import com.hx.entity.Table;
import com.hx.mapper.SysParamMapper;
import com.hx.mapper.TableMapper;
import com.hx.service.SPMapperService;
import com.hx.util.Erweima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private SysParamMapper sysParamMapper;

    @Autowired
    private TableMapper tableMapper;

    @Value("#{uploadProperties.pathErweima}")
    private String pathErweima;

    static Map<String,Object> sysParMap = new HashMap<>();

    //这个方法是查询系统参数并进行map的包装
    @Override
    public Map<String, Object> selectSP() {
        Map<String,Object> map = new HashMap<>();
        Map<String,String> valueMap = null;
        List<SysParam> systemParametersList = sysParamMapper.selectAll();
        for(SysParam systemParameter:systemParametersList){
            if(null==(map.get(systemParameter.getSysParamField()))){
                System.out.println(map);
                valueMap = new LinkedHashMap<>();
                valueMap.put(systemParameter.getSysParamValue(),systemParameter.getSysParamText());
                map.put(systemParameter.getSysParamField(),valueMap);
            }else{
                valueMap = (Map<String,String>)map.get(systemParameter.getSysParamField());
                valueMap.put(systemParameter.getSysParamValue(),systemParameter.getSysParamText());
            }
        }
        return map;
    }

    //该方法表示在程序加载时就获取数据。
    @PostConstruct  //表示在构造方法调用后执行
    public void select(){
        Map<String, Object> map = selectSP();
        System.out.println(map);
        sysParMap = map;
    }

    //该方法表示生成二维码图片
    public void generationPice() throws Exception {

        //这是查询数据库的字符串,把它们遍历出来放入生成器。
        List<Table> table = tableMapper.selectTableAll();
        String path=pathErweima;
        System.out.printf("D:/wordTool/git-repo/clone-repo1/rpo3/dcSystem/dcSystem/src/main/webapp/erweima"+pathErweima);
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
