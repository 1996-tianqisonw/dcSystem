package com.hx.service;

import com.hx.entity.BusShopCart;

import java.util.List;

public interface BusShopCartService extends BaseService<BusShopCart> {

    List<BusShopCart> selectShopGoodsDcListPair(BusShopCart busShopCart);
}