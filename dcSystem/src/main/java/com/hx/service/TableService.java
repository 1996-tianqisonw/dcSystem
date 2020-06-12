package com.hx.service;

import com.hx.entity.Table;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;

/**
 * Created by admin on 2020/5/21.
 */
public interface TableService extends BaseService<Table>{
        int insert(Table record) throws Exception;
}
