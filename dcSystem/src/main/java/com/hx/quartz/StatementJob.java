package com.hx.quartz;

import com.hx.entity.Statement;
import com.hx.entity.StatementLog;
import com.hx.service.StatementLogService;
import com.hx.service.StatementService;
import com.hx.util.SpringContextUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class StatementJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        int statementResult = 1;
        int returnResult = 1;
        int logResult = 1;

        System.out.println("正在执行任务");
        //获取当前时间减去一天
        LocalDate localDate = LocalDate.now().minusDays(1);
        StatementService statementService = (StatementService) SpringContextUtil.getBean("statementService");
        StatementLogService logService = (StatementLogService) SpringContextUtil.getBean("statementLogService");
        List<Statement> statements = new ArrayList<>();
        List<Statement> returnStatements = new ArrayList<>();
        try{
            //调用根据日期统计订单的方法
            statements = statementService.selectByOrder2(localDate);
        }catch (Exception ex){
            statementResult = 0;
        }
        try{
            //调用根据日期统计退单的方法
            returnStatements = statementService.selectByReturn2(localDate);
        }catch (Exception ex){
            returnResult = 0;
        }

        try{
            //遍历获取的数据
            for(Statement s:statements){
                if(returnStatements.size() != 0){
                    for(Statement s2:returnStatements){
                        if(s.getOrderId().equals(s2.getOrderId())){
                            s.setReturnMoney(s2.getReturnMoney());
                            s.setReturnNum(s2.getReturnNum());
                            s.setRealMoney(String.valueOf(Integer.parseInt(s.getTotalMoney()) - Integer.parseInt(s2.getReturnMoney())));
                            s.setRealNum(String.valueOf(Integer.parseInt(s.getTotalNum())-Integer.parseInt(s2.getReturnNum())));
                            break;
                        }else{
                            s.setReturnNum("0");
                            s.setReturnMoney("0");
                            s.setRealNum(s.getTotalNum());
                            s.setRealMoney(s.getTotalMoney());
                        }
                    }
                }else {
                    s.setReturnNum("0");
                    s.setReturnMoney("0");
                    s.setRealNum(s.getTotalNum());
                    s.setRealMoney(s.getTotalMoney());
                }
                //自动生成主键
                s.setStatementId(UUID.randomUUID().toString());
                //调用添加数据的方法
                System.out.println("=====");
                statementService.insert(s);
            }
        }catch (Exception ex){
            logResult = 0;
        }

        StatementLog statementLog = new StatementLog();
        //写入日志
        if(statementResult == 1&& returnResult == 1&& logResult == 1){
            statementLog.setLogContent("抽取正常");
            statementLog.setOperStatus("1");
        }else {
            statementLog.setLogContent("抽取失败");
            statementLog.setOperStatus("0");
        }
        statementLog.setCountDate(localDate.toString());
        statementLog.setLogId(UUID.randomUUID().toString());
        statementLog.setOperTime(new Date());
        try {
            logService.insert(statementLog);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

