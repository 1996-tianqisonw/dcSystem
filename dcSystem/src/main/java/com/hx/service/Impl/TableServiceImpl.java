package com.hx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.Parameter;
import com.hx.entity.Table;
import com.hx.service.TableService;;
import com.hx.util.Erweima;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.xml.ws.spi.http.HttpContext;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2020/5/21.
 */
@Service("tableService")
public class TableServiceImpl extends BaseServiceImpl<Table> implements TableService {
    @Value("#{uploadProperties.pathErweima}")
    private String pathErweima;

    @Override
    public <String> int deleteByPrimaryKey(String dcId) {
        int i = tableMapper.deleteByPrimaryKey(dcId);
        return i;
    }

    @Override
    public int insert(Table record) throws Exception {
        Date date = null;
        if(record.getDcQrcode()==null&&record.getDcId()!=null){
            //这是
           /* String path = httpContext.getPath()+"erweima";
            System.out.println(path);*/
            String url="http://localhost:8080/"+record.getDcId();
            String path=pathErweima;
            System.out.printf("读配置文件得到的文件路径："+pathErweima);
            //这里生成餐桌二维码的地方
            Erweima.create(url,record.getDcId(),path);
            record.setDcQrcode(url);
        }
        if(record.getDcCreatetime()==null){
            date = getSystemTime();
            record.setDcCreatetime(date);
        }
        if(record.getDcUpdatetime()==null){
            //第一添加的餐桌，其更新时间与创建时间一致。
            record.setDcUpdatetime(date);
        }
        int i = tableMapper.insert(record);
        return i;
    }

    @Override
    public int insertSelective(Table record) {
        return 0;
    }

    @Override
    public <String> Table selectByPrimaryKey(String dcId) {
       Table table = tableMapper.selectByPrimaryKey(dcId);
        return table;
    }

    @Override
    public int updateByPrimaryKeySelective(Table record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Table record) {

        //这是查询该主键下的信息
        Table table = selectByPrimaryKey(record.getDcId());
        //这是将没修改的信息在附属回去
        if(record.getDcQrcode()==null||record.getDcQrcode()==""){
            record.setDcQrcode(table.getDcQrcode());
        }
        if (record.getDcCreatetime()==null){
            record.setDcCreatetime(table.getDcCreatetime());
        }
        if(record.getDcUpdatetime()==null){
            Date date = getSystemTime();
            record.setDcUpdatetime(date);
        }
        if(record.getDcUsestatus()==null){
            record.setDcUsestatus(table.getDcUsestatus());
        }
        if(record.getDcForm()==null){
            record.setDcForm(table.getDcForm());
        }
        if(record.getDcUpdatereason()==null){
            record.setDcUpdatereason(table.getDcUpdatereason());
        }
        //这是修改的方法
        int i = tableMapper.updateByPrimaryKey(record);
        return i;
    }

    @Override
    public PageInfo<Table> selectServiceAll(Table table, Integer pageIndex, Integer pageSize) {
        //由于查询条件的下拉框为数字，导致mapper文件的查询条件从!=null变为!=0
        //由于页面加载时的查询没经过查询条件，所以不是0而是null,所以要转换成0.
        if(table.getDcUsestatus()==null){
            table.setDcUsestatus(0);
        }
        if(table.getDcForm()==null){
            table.setDcForm(0);
        }
        //这是避免没输入的unfiend 的情况，没有当成null,而是空字符，导致查询不出结果。
        if(table.getDcId()==""){
            table.setDcId(null);
        }
        if(table.getDcName()==""){
            table.setDcName(null);
        }
        //这是使用分页工具对页大小和当前页进行封装
        System.out.println(pageIndex+","+pageSize);
        PageHelper.startPage(pageIndex,pageSize);
        //这是查询所有的信息
        List<Table> list = tableMapper.selectAll(table);
        //这是与系统参数进行匹配，返回对应的系统参数text值给页面
        for(Table lsi:list){
            if(lsi.getDcForm()!=null){
                Parameter parameter = new Parameter();
                parameter.setField("dc_form");
                String ui = String.valueOf(lsi.getDcForm());
                parameter.setValue(ui);
                String text = sysParameterCheck(parameter);
                lsi.setDcFormText(text);
            }
            if(lsi.getDcSpecifications()!=null){
                Parameter parameter = new Parameter();
                parameter.setField("dc_specifications");
                String ui = String.valueOf(lsi.getDcSpecifications());
                parameter.setValue(ui);
                String text = sysParameterCheck(parameter);
                lsi.setDcSpecificationsText(text);
            }
            if(lsi.getDcUsestatus()!=null){
                Parameter parameter = new Parameter();
                parameter.setField("dc_useStatus");
                String ui = String.valueOf(lsi.getDcUsestatus());
                parameter.setValue(ui);
                String text = sysParameterCheck(parameter);
                lsi.setDcUsestatusText(text);
            }
        }
        PageInfo<Table> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

}
