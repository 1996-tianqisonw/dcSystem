package com.hx.service.Impl;

import com.hx.entity.WaitOn;
import com.hx.mapper.BaseMapper;
import com.hx.mapper.WaitOnMapper;
import com.hx.service.WaitOnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/5/17.
 */
@Service
public class WaitOnServiceImpl extends YonlieServiceImpl<WaitOn> implements WaitOnService {

    @Autowired
    private WaitOnMapper wait_onMapper;

    @Override
    public BaseMapper<WaitOn> getMapper() {
        return wait_onMapper;
    }

    @Override
    public int updateOn_state(int id, String state) {
        WaitOn wait_on = new WaitOn();
        wait_on.setOnOffId(id);
        wait_on.setOnOffState(state);
        wait_on.setUpdateTime(getDatetoString());
        return wait_onMapper.updateByPrimaryKeySelective(wait_on);
    }

    @Override
    public boolean WaitOnorOff(String dp_id) {
        WaitOn wait_on = new WaitOn();
        wait_on = wait_onMapper.WaitOnorOff(dp_id);
        if ("1".equals(wait_on.getOnOffState())) {
            return true;
        } else {
            return false;
        }
    }
}
