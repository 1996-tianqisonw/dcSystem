package com.hx.service;

import com.hx.entity.TableState;

/**
 * Created by admin on 2020/5/24.
 */
public interface tableStateService extends BaseService<TableState>{
    public int stateUsedUp(TableState tableState);
}
