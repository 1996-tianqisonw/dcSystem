package com.hx.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BusOrder implements Serializable {
    private String orderId;

    private Long sysParamId;

    private String shopCartId;

    private String currentDiningId;

    private String currentDiningName;

    private String payType;

    private String whetherPay;

    private String payWay;

    private String orderType;

    private String relevanceId;

    private Integer orderTotal;

    private Integer payMoney;

    private String orderStatus;

    private String cancelStatus;

    private Date creationTime;

    private Date endTime;

    private String expenseId;

    private String clerkId;

    private Integer phone;

    private String address;

    private String explains;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getSysParamId() {
        return sysParamId;
    }

    public void setSysParamId(Long sysParamId) {
        this.sysParamId = sysParamId;
    }

    public String getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(String shopCartId) {
        this.shopCartId = shopCartId;
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

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getWhetherPay() {
        return whetherPay;
    }

    public void setWhetherPay(String whetherPay) {
        this.whetherPay = whetherPay;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getRelevanceId() {
        return relevanceId;
    }

    public void setRelevanceId(String relevanceId) {
        this.relevanceId = relevanceId;
    }

    public Integer getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Integer orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCancelStatus() {
        return cancelStatus;
    }

    public void setCancelStatus(String cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getClerkId() {
        return clerkId;
    }

    public void setClerkId(String clerkId) {
        this.clerkId = clerkId;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains;
    }

    @Override
    public String toString() {
        return "BusOrder{" +
                "orderId='" + orderId + '\'' +
                ", sysParamId=" + sysParamId +
                ", shopCartId='" + shopCartId + '\'' +
                ", currentDiningId='" + currentDiningId + '\'' +
                ", currentDiningName='" + currentDiningName + '\'' +
                ", payType='" + payType + '\'' +
                ", whetherPay='" + whetherPay + '\'' +
                ", payWay='" + payWay + '\'' +
                ", orderType='" + orderType + '\'' +
                ", relevanceId='" + relevanceId + '\'' +
                ", orderTotal=" + orderTotal +
                ", payMoney=" + payMoney +
                ", orderStatus='" + orderStatus + '\'' +
                ", cancelStatus='" + cancelStatus + '\'' +
                ", creationTime=" + creationTime +
                ", endTime=" + endTime +
                ", expenseId='" + expenseId + '\'' +
                ", clerkId='" + clerkId + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", explains='" + explains + '\'' +
                '}';
    }
}