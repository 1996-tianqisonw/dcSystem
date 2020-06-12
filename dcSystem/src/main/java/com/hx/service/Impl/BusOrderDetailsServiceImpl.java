package com.hx.service.Impl;

import com.hx.entity.BusOrderDetails;
import com.hx.service.BusOrderDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2020/5/28.
 */
@Service("busOrderDetailsService")
public class BusOrderDetailsServiceImpl extends BaseServiceImpl<BusOrderDetails> implements BusOrderDetailsService {

/*    @Override
    public PageInfo<BusOrderDetails> selectPageOrderId(String orderId, Integer pageIndex, Integer pageSize) {
        //startPage：设置的分页查询条件，它只起作用于接下来的第一条执行的sql
        PageHelper.startPage(pageIndex, pageSize);
        //查询数据
        List<BusOrderDetails> list= busOrderDetailsMapper.selectPageOrderId(orderId);
        System.out.println("List<BusOrderDetails> li= "+list);
        //封装查询信息，便于使用
        PageInfo<BusOrderDetails> pageInfo = new PageInfo<BusOrderDetails>(list);

        return pageInfo;
    }*/
}
