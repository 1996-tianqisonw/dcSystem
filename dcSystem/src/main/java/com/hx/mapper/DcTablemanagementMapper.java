package com.hx.mapper;

import com.hx.entity.DcTablemanagement;

public interface DcTablemanagementMapper extends BaseMapper<DcTablemanagement>{

    public DcTablemanagement selectDcId(String dc);
}