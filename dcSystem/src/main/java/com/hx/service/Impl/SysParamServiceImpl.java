package com.hx.service.Impl;

import com.hx.entity.SysParam;
import com.hx.service.SysParamService;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2020/5/28.
 */
@Service("sysParamService")
public class SysParamServiceImpl extends BaseServiceImpl<SysParam> implements SysParamService {

    @Override
    public void updateSysParam(SysParam sysParam) {
        sysParamMapper.updateSysParam(sysParam);
    }

    @Override
    public void setSysParam(SysParam sysParam) {
        sysParamMapper.setSysParam(sysParam);
    }

}
