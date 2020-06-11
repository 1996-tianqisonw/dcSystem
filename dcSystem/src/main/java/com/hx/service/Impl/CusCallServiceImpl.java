package com.hx.service.Impl;

import com.hx.entity.CusCall;
import com.hx.mapper.BaseMapper;
import com.hx.mapper.CusCallMapper;
import com.hx.service.CusCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/5/17.
 */
@Service
public class CusCallServiceImpl extends  YonlieServiceImpl<CusCall> implements CusCallService {
    @Autowired
    private CusCallMapper cus_callMapper;
    @Override
    public BaseMapper<CusCall> getMapper() {
        return cus_callMapper;
    }

    @Override
    public int updateByPrimaryKeySelective(String[] ids) {
        CusCall cus_call=new CusCall();
        cus_call.setDealTime(getDatetoString());
        cus_call.setIds(ids);
        cus_call.setDealState("1");
        return cus_callMapper.updateByPrimaryKeySelective(cus_call);
    }
}
