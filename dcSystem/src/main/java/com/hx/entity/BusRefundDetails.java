package com.hx.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BusRefundDetails implements Serializable {
    private Long sysParamId;

    private String refundId;

    private String refundDetailsId;

    private String goodsName;

    private Integer goodsCount;

    private String goodsImgAddress;

    private Integer refundMoney;

    private String refundStatus;

    private Date refundTime;

    private String clientId;

    private String goodsBrand;

    private String explains;

    public Long getSysParamId() {
        return sysParamId;
    }

    public void setSysParamId(Long sysParamId) {
        this.sysParamId = sysParamId;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getRefundDetailsId() {
        return refundDetailsId;
    }

    public void setRefundDetailsId(String refundDetailsId) {
        this.refundDetailsId = refundDetailsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getGoodsImgAddress() {
        return goodsImgAddress;
    }

    public void setGoodsImgAddress(String goodsImgAddress) {
        this.goodsImgAddress = goodsImgAddress;
    }

    public Integer getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(Integer refundMoney) {
        this.refundMoney = refundMoney;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains;
    }

    @Override
    public String toString() {
        return "BusRefundDetails{" +
                "sysParamId=" + sysParamId +
                ", refundId='" + refundId + '\'' +
                ", refundDetailsId='" + refundDetailsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsCount='" + goodsCount + '\'' +
                ", goodsImgAddress=" + goodsImgAddress +
                ", refundMoney=" + refundMoney +
                ", refundStatus='" + refundStatus + '\'' +
                ", refundTime=" + refundTime +
                ", clientId='" + clientId + '\'' +
                ", goodsBrand='" + goodsBrand + '\'' +
                ", explains='" + explains + '\'' +
                '}';
    }
}