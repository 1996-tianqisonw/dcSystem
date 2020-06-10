package com.hx.mapper;

import com.hx.entity.SystemParameters;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SystemParametersMapper {
    List<SystemParameters> selectAll();
}