package com.hx.service;

import com.hx.entity.SysParam;

public interface SysParamService extends BaseService<SysParam> {
    void updateSysParam(SysParam sysParam);

    void setSysParam(SysParam sysParam);
}