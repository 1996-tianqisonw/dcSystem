package com.hx.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class BusOrderDetails implements Serializable {
    private Long sysParamId;

    private String orderId;

    private String goodsId;

    private String goodsOrderId;

    private Integer goodsCount;

    private Integer goodsUnits;

    private Integer goodsPrice;

    private Integer goodsTotal;

    private String goodsImgAddress;

    private String goodsTitle;

    private String goodsProcess;

    private String explains;

    public Long getSysParamId() {
        return sysParamId;
    }

    public void setSysParamId(Long sysParamId) {
        this.sysParamId = sysParamId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsOrderId() {
        return goodsOrderId;
    }

    public void setGoodsOrderId(String goodsOrderId) {
        this.goodsOrderId = goodsOrderId;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getGoodsUnits() {
        return goodsUnits;
    }

    public void setGoodsUnits(Integer goodsUnits) {
        this.goodsUnits = goodsUnits;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsTotal() {
        return goodsTotal;
    }

    public void setGoodsTotal(Integer goodsTotal) {
        this.goodsTotal = goodsTotal;
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

    public String getGoodsProcess() {
        return goodsProcess;
    }

    public void setGoodsProcess(String goodsProcess) {
        this.goodsProcess = goodsProcess;
    }

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains;
    }

    @Override
    public String toString() {
        return "BusOrderDetails{" +
                "sysParamId=" + sysParamId +
                ", orderId='" + orderId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsOrderId='" + goodsOrderId + '\'' +
                ", goodsCount=" + goodsCount +
                ", goodsUnits=" + goodsUnits +
                ", goodsPrice=" + goodsPrice +
                ", goodsTotal=" + goodsTotal +
                ", goodsImgAddress='" + goodsImgAddress + '\'' +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsProcess='" + goodsProcess + '\'' +
                ", explains='" + explains + '\'' +
                '}';
    }
}