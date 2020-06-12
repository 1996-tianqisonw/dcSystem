package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.entity.BusOrder;
import com.hx.entity.BusRefund;
import com.hx.entity.BusRefundDetails;
import com.hx.entity.Goods;
import com.hx.service.BusOrderService;
import com.hx.service.BusRefundDetailsService;
import com.hx.service.BusRefundService;
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
@RequestMapping("busRefund")
public class BusRefundController extends BaseController {

    @Resource
    private BusRefundService busRefundService;

    @Resource
    private BusOrderService busOrderService;

    @Resource
    private BusRefundDetailsService busRefundDetailsService;


    @RequestMapping("addRefund")
    @ResponseBody
        public Object addRefund(BusRefund busRefund) throws Exception {

      //  System.out.println("状态 ="+busRefund.getRefundStatus()+" 审核 ="+busRefund.getAuditStatus());
        List<BusOrder> busOrder = busOrderService.selectList();

        //系统日期
        String strNow = new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();
        //随机数
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
        //System.out.println("o = "+strNow+o);

        //退款订单编号
        String refundOrderId = strNow+o;

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
       // System.out.println("时间 = "+date1);

        List<BusRefund> refundList = new ArrayList<BusRefund>();

        //List<BusRefund> refundId = busRefundService.selectList();

/*       for(int k=0;k< refundId.size();k++)
        {
                System.out.println("refundId.get(k).getRefundId() 321312="+ refundId.get(k).getRefundId());
        }*/
        System.out.println("busRefund.getOrderId() 123123123212321312321312312321 = "+busRefund.getOrderId());
        //&&(busRefund.getRefundStatus().equals("未付款")&&busOrder.get(j).getWhetherPay().equals("未付款"))||(!busRefund.getRefundStatus().equals("未付款")&&busOrder.get(j).getWhetherPay().equals("未付款"))||(busRefund.getRefundStatus().equals("未付款")&&busOrder.get(j).getWhetherPay().equals("已付款"))
        for(int j=0;j<busOrder.size();j++)
        {
            if(busOrder.get(j).getOrderId().equals(busRefund.getOrderId())&&busRefund.getRefundStatus().equals("未付款"))
            {
                //&&busRefund.getRefundStatus().equals("未付款")
                /*busRefund.getRefundStatus().equals("未付款")&&busOrder.get(j).getWhetherPay().equals("未付款")*/
                //if()
               // {
                    BusRefund nowBbusRefund = new BusRefund();
                    nowBbusRefund.setOrderId(busOrder.get(j).getOrderId());
                    nowBbusRefund.setRefundId(busOrder.get(j).getOrderId());
                    nowBbusRefund.setRefundOrderId(refundOrderId);
                    nowBbusRefund.setOriginalOrderId(busOrder.get(j).getOrderId());
                    nowBbusRefund.setCurrentDiningId(busOrder.get(j).getCurrentDiningId());
                    nowBbusRefund.setCurrentDiningName(busOrder.get(j).getCurrentDiningName());

                    nowBbusRefund.setRefundMoney(0);
                    nowBbusRefund.setPayWay("");

                    nowBbusRefund.setRefundStatus(busRefund.getRefundStatus());
                    nowBbusRefund.setAuditStatus(busRefund.getAuditStatus());
                    nowBbusRefund.setRefundTime(date1);
                    busRefundService.insert(nowBbusRefund);

                    //refundList.add(nowBbusRefund);
                }else if(busOrder.get(j).getOrderId().equals(busRefund.getOrderId())&&!busRefund.getRefundStatus().equals("未付款")){
                    /*if(!busRefund.getRefundStatus().equals("未付款")&&busOrder.get(j).getWhetherPay().equals("已付款"))
                    {*/
                    BusRefund nowBbusRefund = new BusRefund();
                    nowBbusRefund.setOrderId(busOrder.get(j).getOrderId());
                    nowBbusRefund.setRefundId(busOrder.get(j).getOrderId());
                    nowBbusRefund.setRefundOrderId(refundOrderId);
                    nowBbusRefund.setOriginalOrderId(busOrder.get(j).getOrderId());
                    nowBbusRefund.setCurrentDiningId(busOrder.get(j).getCurrentDiningId());
                    nowBbusRefund.setCurrentDiningName(busOrder.get(j).getCurrentDiningName());
                    nowBbusRefund.setRefundMoney(busOrder.get(j).getOrderTotal());
                    nowBbusRefund.setRefundStatus(busRefund.getRefundStatus());
                    nowBbusRefund.setAuditStatus(busRefund.getAuditStatus());
                    nowBbusRefund.setPayWay(busOrder.get(j).getPayWay());
                    nowBbusRefund.setRefundTime(date1);
                    busRefundService.insert(nowBbusRefund);
                    //refundList.add(nowBbusRefund);
                    //  }
                }
           // }

        }

       // busRefundService.insertBatch(refundList);

        //下面的是添加退单详细
        List<BusRefundDetails> arrBusRefundDetails = new ArrayList<>();

        //系统日期
        String strNow1 = new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();
        //随机数
        ArrayList list1 = new ArrayList();
        int max1=9;
        int min1 =0;
        for (int i=0;i<6;i++){
            list1.add((int)(min1+Math.random()*max1)) ;
        }
        Object o1="";

        for(int i =0;i<list1.size();i++)
        {
            o1 =o1+""+ list1.get(i);
        }
        System.out.println("o1 = "+strNow1+o1);
        //退款明细订单编号
        String refundOrderId1 = strNow1+o1;

        Date date2 =new Date();
        Date date3 =null;
        //格式化
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime1 = sdf1.format(date2);
        try {
            date3 = sdf1.parse(nowTime1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Goods> goodsList = EntitySave.goodsList;
        System.out.println("goodsList1 32132132112312 = "+goodsList);
        System.out.println("goodsList1 size = "+goodsList.size());

        for(int n=0;n<goodsList.size();n++)
        {
            if(goodsList.get(n).getGoodsNo()!=null)
            {
                BusRefundDetails busRefundDetails = new BusRefundDetails();
                busRefundDetails.setRefundId(busRefund.getOrderId());
                busRefundDetails.setRefundDetailsId(refundOrderId1);
                busRefundDetails.setGoodsName(goodsList.get(n).getGoodsName());
                busRefundDetails.setGoodsCount(1);
                busRefundDetails.setGoodsImgAddress(goodsList.get(n).getGoodsImg());
                busRefundDetails.setRefundMoney(goodsList.get(n).getGoodsPrice());
                busRefundDetails.setRefundStatus(busRefund.getRefundStatus());
                busRefundDetails.setRefundTime(date3);
                arrBusRefundDetails.add(busRefundDetails);
            }
        }

        int i = busRefundDetailsService.insertBatch(arrBusRefundDetails);

        Map<String,String> map = new HashMap<>();

        if(i>0)
        {
            map.put("msg","申请成功！");
        }else {
            map.put("msg","申请失败！");
        }

        return map;
    }

    @RequestMapping("selectRefundPage")
    @ResponseBody
    public Object selectRefundPage(BusRefund busRefund, Integer page, Integer rows) {

        PageInfo<BusRefund> pageInfo = busRefundService.selectPage(busRefund,page,rows);

        return getPageMap(pageInfo);
    }
}
