package com.hx.service.Impl;

import com.hx.entity.BusShopCart;
import com.hx.service.BusShopCartService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lenovo on 2020/5/28.
 */
@Service("busShopCartService")
public class BusShopCartServiceImpl extends BaseServiceImpl<BusShopCart> implements BusShopCartService {

    @Override
    public List<BusShopCart> selectShopGoodsDcListPair(BusShopCart busShopCart) {

        return busShopCartMapper.selectShopGoodsDcListPair(busShopCart);
    }
}
