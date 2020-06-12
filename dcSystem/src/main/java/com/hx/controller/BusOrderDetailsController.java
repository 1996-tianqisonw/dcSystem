package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.entity.BusOrderDetails;
import com.hx.service.BusOrderDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Lenovo on 2020/5/28.
 */
@Controller
@RequestMapping("busOrderDetails")
public class BusOrderDetailsController extends BaseController {

    @Resource
    private BusOrderDetailsService busOrderDetailsService;

    BusOrderDetails busOrderDetails = new BusOrderDetails();

    @RequestMapping("/orderId")
    @ResponseBody
    public void orderId(HttpServletRequest request) {

         String orderId = request.getParameter("orderIdValue1");

        busOrderDetails.setGoodsOrderId(orderId);

    }

    @RequestMapping("/selectBusOrderDetails")
    @ResponseBody
    public Object BusOrderDetails(Integer page, Integer rows) {

        //调用业务层查询数据
        PageInfo<BusOrderDetails> pageInfo = busOrderDetailsService.selectPage(busOrderDetails, page, rows);
        System.out.println("pageInfo = " + pageInfo);
        //return null;
        return getPageMap(pageInfo);
    }

}
