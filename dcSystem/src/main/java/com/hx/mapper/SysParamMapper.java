package com.hx.mapper;

import com.hx.entity.SysParam;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SysParamMapper extends BaseMapper<SysParam>{
    //加载所有参数信息
    List<SysParam> loadSysParam();
    //分页查询
    List<SysParam> selectPage(SysParam sysParam);

    void updateSysParam(SysParam sysParam);

    void setSysParam(SysParam sysParam);

    List<SysParam> selectAll();
}