package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.entity.BusOrder;
import com.hx.entity.BusOrderDetails;
import com.hx.entity.DcTablemanagement;
import com.hx.entity.Goods;
import com.hx.service.BusOrderDetailsService;
import com.hx.service.BusOrderService;
import com.hx.service.DcTablemanagementService;
import com.hx.util.EntitySave;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Lenovo on 2020/5/28.
 */
@Controller
@RequestMapping("busOrder")
public class BusOrderController extends BaseController {

    @Resource
    private BusOrderDetailsService busOrderDetailsService;

    @Resource
    private BusOrderService busOrderService;

    @Resource
    private DcTablemanagementService dcTablemanagementService;

    //添加订单
    @RequestMapping("insertOrder")
    @ResponseBody
    public Object insertOrder(BusOrder busOrder) throws Exception {

        System.out.println("busOrder = " + busOrder);

        DcTablemanagement dc =  dcTablemanagementService.selectDcId(busOrder.getCurrentDiningId());
        System.out.println("dcId = "+dc.getDcId()+"  dcName = "+dc.getDcName());

        String strNow = new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();

        ArrayList list = new ArrayList();
        int max=9;
        int min =0;
        for (int i=0;i<6;i++){
            list.add((int)(min+Math.random()*max)) ;
        }
        Object o="";

        for(int i =0;i<list.size();i++)
        {
            o =o+""+ list.get(i);
        }
        System.out.println("o = "+strNow+o);

        //订单编号
        String orderId = strNow+o;

        BusOrder addBusOrder = new BusOrder();
        addBusOrder.setCurrentDiningId(dc.getDcId());//餐桌id
        addBusOrder.setCurrentDiningName(dc.getDcName());//餐桌名称
        addBusOrder.setOrderId(orderId);//订单编号
        //addBusOrder.setOrderType(busOrder.getOrderType());//订单类型
        addBusOrder.setOrderStatus(busOrder.getOrderStatus());//订单状态
        addBusOrder.setWhetherPay(busOrder.getWhetherPay());//是否付款

        Date date=new Date();
        Date date1 =null;
        //格式化
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(date);
        try {
            date1 = sdf.parse(nowTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("时间 = "+date1);

        addBusOrder.setCreationTime(date1);//下单时间
        addBusOrder.setEndTime(date1);//支付时间

        if(busOrder.getWhetherPay().equals("已付款"))
        {
            addBusOrder.setPayWay(busOrder.getPayWay());//付款方式
        }else{
            addBusOrder.setPayWay("");
        }

        //总金额
        List<Goods> Moneylist = new ArrayList<Goods>();
        Moneylist = EntitySave.goodsList;

        int total = 0;

        for(int i=0;i<Moneylist.size();i++)
        {
            total += Moneylist.get(i).getGoodsPrice();
        }
        System.out.println("总金额 = "+total);

        addBusOrder.setOrderTotal(total);//订单总金额

        //订单状态，应付金额
        if(busOrder.getOrderStatus().equals("取消单"))
        {
            addBusOrder.setPayMoney(0);//应付金额
        }else
        {
            addBusOrder.setPayMoney(total);//应付金额
        }

        int i = busOrderService.insert(addBusOrder);

        //下面的是添加订单详细
        List<BusOrderDetails> arrBusOrderDetails = new ArrayList<>();

        List<Goods> goodsList = EntitySave.goodsList;

        for(int j=0;j<goodsList.size();j++)
        {
            if(goodsList.get(j).getGoodsNo()!=null)
            {
                BusOrderDetails busOrderDetails = new BusOrderDetails();
                busOrderDetails.setOrderId(orderId);
                busOrderDetails.setGoodsId(goodsList.get(j).getGoodsNo());
                busOrderDetails.setGoodsOrderId(orderId);
                busOrderDetails.setGoodsCount(1);
                busOrderDetails.setGoodsPrice(goodsList.get(j).getGoodsPrice());
                busOrderDetails.setGoodsImgAddress(goodsList.get(j).getGoodsImg());
                busOrderDetails.setGoodsTitle(goodsList.get(j).getGoodsTitle());
                busOrderDetails.setGoodsTotal(goodsList.get(j).getGoodsPrice());
                busOrderDetails.setGoodsProcess(busOrder.getOrderType());
                arrBusOrderDetails.add(busOrderDetails);
            }

        }

        i = busOrderDetailsService.insertBatch(arrBusOrderDetails);

        //某个订单的商品，订单编号作为key,需要的商品作为值
/*        Map<String,Object> orderGoodsMap = new HashMap<String,Object>();
        orderGoodsMap.put(addBusOrder.getOrderId(), EntitySave.goodsList);*/


        Map<String, String> map = new HashMap<>();
        if (i > 0) {
            map.put("msg", "提交成功！");
        } else {
            map.put("msg", "提交失败！");
        }
        return map;
    }

    //查询订单
    @RequestMapping("selectOrderPage")
    @ResponseBody
    public Object selectOrderPage(BusOrder busOrder, Integer page, Integer rows)
    {
        //调用业务层查询数据
        PageInfo<BusOrder> pageInfo = busOrderService.selectPage(busOrder, page, rows);
        //System.out.println("busOrder = " + getPageMap(pageInfo));

        return getPageMap(pageInfo);
    }

}
