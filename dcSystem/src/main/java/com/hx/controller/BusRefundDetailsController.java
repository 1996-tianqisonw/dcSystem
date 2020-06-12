package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.entity.BusRefundDetails;
import com.hx.service.BusRefundDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Lenovo on 2020/5/28.
 */
@Controller
@RequestMapping("busRefundDetails")
public class BusRefundDetailsController extends BaseController {

    @Resource
    private BusRefundDetailsService busRefundDetailsService;

    BusRefundDetails busRefundDetails = new BusRefundDetails();

    @RequestMapping("/refundId")
    @ResponseBody
    public void refundId(HttpServletRequest request) {

        String refundId = request.getParameter("refundIdValue1");

        busRefundDetails.setRefundId(refundId);

    }

    @RequestMapping("/selectBusRefundDetails")
    @ResponseBody
    public Object selectBusRefundDetails(Integer page, Integer rows) {

        //调用业务层查询数据
        PageInfo<BusRefundDetails> pageInfo = busRefundDetailsService.selectPage(busRefundDetails, page, rows);
        System.out.println("pageInfo = " + pageInfo);
        //return null;
        return getPageMap(pageInfo);
    }
}
