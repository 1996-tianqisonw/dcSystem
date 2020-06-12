package com.hx.service;

import com.hx.entity.DcTablemanagement;

public interface DcTablemanagementService extends BaseService<DcTablemanagement> {

    public DcTablemanagement selectDcId(String dc);
}