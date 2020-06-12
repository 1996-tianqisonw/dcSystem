package com.hx.entity;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {
    private Integer goodsId;

    private String shopCartId;

    private Integer cId;

    private String goodsName;

    private String goodsTitle;

    private String goodsNo;

    private String goodsImg;

    private Integer goodsPrice;

    private String goodsDescriptive;

    private String goodsStatus;

    private Date addTime;

    private String specification;

    private BusShopCart busShopCart;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(String shopCartId) {
        this.shopCartId = shopCartId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDescriptive() {
        return goodsDescriptive;
    }

    public void setGoodsDescriptive(String goodsDescriptive) {
        this.goodsDescriptive = goodsDescriptive;
    }

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public BusShopCart getBusShopCart() {
        return busShopCart;
    }

    public void setBusShopCart(BusShopCart busShopCart) {
        this.busShopCart = busShopCart;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", shopCartId='" + shopCartId + '\'' +
                ", cId=" + cId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsNo='" + goodsNo + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsDescriptive='" + goodsDescriptive + '\'' +
                ", goodsStatus='" + goodsStatus + '\'' +
                ", addTime=" + addTime +
                ", specification='" + specification + '\'' +
                ", busShopCart=" + busShopCart +
                '}';
    }
}