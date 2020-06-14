package com.hx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.Statement;
import com.hx.service.StatementService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by huangyu on 2020/6/1.
 */
@Service("statementService")
public class StatementServiceImpl extends BaseServiceImpl<Statement> implements StatementService {
   /* @Autowired
    protected StatementMapper statementMapper;*/

    //根据日期和店铺id统计订单
    @Override
    public List<Statement> selectByOrder(LocalDate countDate, String shopId) {
        return statementMapper.selectByOrder(countDate,shopId);
    }

    //根据日期统计订单
    @Override
    public List<Statement> selectByOrder2(LocalDate countDate) {
        return statementMapper.selectByOrder2(countDate);
    }

    //根据日期和店铺id统计退单
    @Override
    public List<Statement> selectByReturn(LocalDate countDate, String shopId) {
        System.out.println("时间---"+countDate);
        return statementMapper.selectByReturn(countDate,shopId);
    }

    //根据日期统计退单
    @Override
    public List<Statement> selectByReturn2(LocalDate countDate) {
        return statementMapper.selectByReturn2(countDate);
    }

    @Override
    public PageInfo<Statement> selectByTimes(Integer pageIndex, Integer pageSize, String startDate, String endDate) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Statement> statements = statementMapper.selectByTimes(startDate, endDate);
        PageInfo<Statement> statementPageInfo = new PageInfo<>(statements);
        return statementPageInfo;
    }


}

