package com.hx.mapper;

import com.hx.entity.Statement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StatementMapper extends BaseMapper<Statement> {
    List<Statement> selectByOrder(@Param("countDate") LocalDate countDate, @Param("deptId") String deptId);
    List<Statement> selectByOrder2(@Param("countDate") LocalDate countDate);
    List<Statement> selectByReturn(@Param("countDate") LocalDate countDate, @Param("deptId") String deptId);
    List<Statement> selectByReturn2(@Param("countDate") LocalDate countDate);
    //通过时间段和部门id查询报表
    List<Statement> selectByTimes(@Param("startDate") String startDate, @Param("endDate") String endDate);
}