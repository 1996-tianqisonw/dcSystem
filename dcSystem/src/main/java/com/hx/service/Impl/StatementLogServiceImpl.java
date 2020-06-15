package com.hx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.StatementLog;
import com.hx.service.StatementLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("statementLogService")
public class StatementLogServiceImpl extends BaseServiceImpl<StatementLog> implements StatementLogService {

   /* @Autowired
    private StatementLogMapper statementLogMapper;*/
    @Override
    public PageInfo<StatementLog> selectByTimes1(Integer pageIndex, Integer pageSize, String startDate) {
            PageHelper.startPage(pageIndex,pageSize);
            List<StatementLog> statementLogs = statementLogMapper.selectByTimes1(startDate);
            PageInfo<StatementLog> statementLogPageInfo = new PageInfo<>(statementLogs);
            return statementLogPageInfo;
        }

}
