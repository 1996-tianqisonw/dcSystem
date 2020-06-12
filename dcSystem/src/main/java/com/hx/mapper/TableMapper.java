package com.hx.mapper;

import com.hx.entity.Table;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TableMapper extends BaseMapper<Table>{
    List<Table> selectTableAll();
}