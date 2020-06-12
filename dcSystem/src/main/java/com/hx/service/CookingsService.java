package com.hx.service;

import com.hx.entity.Cooking;

/**
 * Created by admin on 2020/6/11.
 */
public interface CookingsService extends BaseService<Cooking> {
    int updateByPrimaryKey(Cooking record, String mark);
}
