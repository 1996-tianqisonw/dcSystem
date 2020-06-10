package com.hx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.Parameter;
import com.hx.entity.Table;
import com.hx.entity.cookingManagement;
import com.hx.mapper.TableMapper;
import com.hx.service.tableService;
import com.hx.util.Erweima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2020/5/21.
 */
@Service("tableService")
public class tableServiceImpl extends BaseServiceImpl implements tableService {

    @Autowired
    private TableMapper tableMapper;

    @Override
    public <String> int deleteByPrimaryKey(String dcId) {
        int i = tableMapper.deleteByPrimaryKey(dcId);
        return i;
    }

    @Override
    public int insert(Table record) {
        Date date = null;
        if(record.getDcQrcode()==null&&record.getDcId()!=null){
            //这里生成餐桌二维码的地方
            String url="http://localhost:8080/"+record.getDcId();
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
        PageHelper.startPage(pageIndex,pageSize);
        List<Table> list = tableMapper.selectAll(table);
        for(Table lsi:list){
            if(lsi.getDcForm()!=null){
                Parameter parameter = new Parameter();
                parameter.setField("dc_form");
                String ui = String.valueOf(lsi.getDcForm());
                System.out.println(ui);
                parameter.setValue(ui);
                String text = sysParameterCheck(parameter);
                lsi.setDcFormText(text);
            }
            if(lsi.getDcSpecifications()!=null){
                Parameter parameter = new Parameter();
                parameter.setField("dc_specifications");
                String ui = String.valueOf(lsi.getDcSpecifications());
                System.out.println(ui);
                parameter.setValue(ui);
                String text = sysParameterCheck(parameter);
                lsi.setDcSpecificationsText(text);
            }
            if(lsi.getDcUsestatus()!=null){
                Parameter parameter = new Parameter();
                parameter.setField("dc_useStatus");
                String ui = String.valueOf(lsi.getDcUsestatus());
                System.out.println(ui);
                parameter.setValue(ui);
                String text = sysParameterCheck(parameter);
                lsi.setDcUsestatusText(text);
            }
        }
        PageInfo<Table> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

}
