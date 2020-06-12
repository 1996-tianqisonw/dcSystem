package com.hx.mapper;

import com.hx.entity.BusShopCart;

import java.util.List;

public interface BusShopCartMapper extends BaseMapper<BusShopCart>{

    List<BusShopCart> selectShopGoodsDcListPair(BusShopCart busShopCart);
}