package com.hx.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class BusShopCart implements Serializable {
    private String shopCartId;

    private String customerId;

    private String goodsId;

    private Integer goodsCount;

    private Integer goodsUnit;

    private Integer goodsPrice;

    private Integer totalPrice;

    private String goodsImgAddress;

    private String goodsTitle;

    private String currentDiningId;

    private String currentDiningName;

    private String explains;

    private List<Goods> goods;

    private List<DcTablemanagement> dcTablemanagements;

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public List<DcTablemanagement> getDcTablemanagements() {
        return dcTablemanagements;
    }

    public void setDcTablemanagements(List<DcTablemanagement> dcTablemanagements) {
        this.dcTablemanagements = dcTablemanagements;
    }

    public String getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(String shopCartId) {
        this.shopCartId = shopCartId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(Integer goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getGoodsImgAddress() {
        return goodsImgAddress;
    }

    public void setGoodsImgAddress(String goodsImgAddress) {
        this.goodsImgAddress = goodsImgAddress;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getCurrentDiningId() {
        return currentDiningId;
    }

    public void setCurrentDiningId(String currentDiningId) {
        this.currentDiningId = currentDiningId;
    }

    public String getCurrentDiningName() {
        return currentDiningName;
    }

    public void setCurrentDiningName(String currentDiningName) {
        this.currentDiningName = currentDiningName;
    }

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains;
    }

    @Override
    public String toString() {
        return "BusShopCart{" +
                "shopCartId='" + shopCartId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsCount=" + goodsCount +
                ", goodsUnit=" + goodsUnit +
                ", goodsPrice=" + goodsPrice +
                ", totalPrice=" + totalPrice +
                ", goodsImgAddress='" + goodsImgAddress + '\'' +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", currentDiningId='" + currentDiningId + '\'' +
                ", currentDiningName='" + currentDiningName + '\'' +
                ", explains='" + explains + '\'' +
                ", goods=" + goods +
                ", dcTablemanagements=" + dcTablemanagements +
                '}';
    }
}