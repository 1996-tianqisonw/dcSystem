package com.hx.resolver;

import com.hx.exceptions.customEcxeption;
import com.hx.log.logService;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2020/6/3.
 */
   /*
    1.这是异常的总控制器
    2.给分布的异常怎么与统一异常进行对接。
    */
public class exceptionResolver implements HandlerExceptionResolver {

    @Resource
    private logService logService;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        customEcxeption customEcxeption = null;
        if(ex instanceof customEcxeption){
           customEcxeption = (customEcxeption)ex;
        }else{
            //这里写日志
          /*  logService.writeLog(ex.getLocalizedMessage());*/
            //这里自定义一个异常
           customEcxeption = new customEcxeption("系统异常，请联系管理员!");
        }
        return new ModelAndView("forward:/error.jsp","errMsg",customEcxeption.getMessage());
    }
}
