package com.hx.mapper;

import com.hx.entity.Table;
import com.hx.entity.TableState;
import org.springframework.stereotype.Repository;

@Repository
public interface TableStateMapper extends BaseMapper<TableState>{
    int stateUsedUp(TableState tableState);
}