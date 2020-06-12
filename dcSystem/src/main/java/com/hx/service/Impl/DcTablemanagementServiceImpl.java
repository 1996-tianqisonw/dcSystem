package com.hx.service.Impl;

import com.hx.entity.DcTablemanagement;
import com.hx.service.DcTablemanagementService;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2020/5/28.
 */
@Service("dcTablemanagementService")
public class DcTablemanagementServiceImpl extends BaseServiceImpl<DcTablemanagement> implements DcTablemanagementService {

    @Override
    public DcTablemanagement selectDcId(String dc) {

        return dcTablemanagementMapper.selectDcId(dc);
    }
}
