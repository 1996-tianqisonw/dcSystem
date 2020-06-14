package com.hx.mapper;

import com.hx.entity.StatementLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatementLogMapper extends BaseMapper<StatementLog> {
    List<StatementLog> selectByTimes1(@Param("startDate") String startDate);

}