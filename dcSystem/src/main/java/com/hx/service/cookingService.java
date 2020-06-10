package com.hx.service;

import com.hx.entity.cookingManagement;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2020/5/25.
 */
@Service
public interface cookingService extends BaseService<cookingManagement> {
    int updateByPrimaryKey(cookingManagement record,String mark);
}
