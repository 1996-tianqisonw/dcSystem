package com.hx.resolver;

import com.hx.exceptions.CustomEcxeption;
import com.hx.log.LogService;
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
public class ExceptionResolver implements HandlerExceptionResolver {

    @Resource
    private LogService logService;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        CustomEcxeption customEcxeption = null;
        if(ex instanceof CustomEcxeption){
           customEcxeption = (CustomEcxeption)ex;
        }else{
            //这里写日志
          /*  logService.writeLog(ex.getLocalizedMessage());*/
            //这里自定义一个异常
           customEcxeption = new CustomEcxeption("系统异常，请联系管理员!");
        }
        return new ModelAndView("forward:/error.jsp","errMsg",customEcxeption.getMessage());
    }
}
