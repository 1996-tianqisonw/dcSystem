package com.hx.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BusRefund implements Serializable {
    private Long sysParamId;

    private String orderId;

    private String refundId;

    private String refundOrderId;

    private String originalOrderId;

    private String currentDiningId;

    private String currentDiningName;

    private Integer refundMoney;

    private String refundStatus;

    private String auditStatus;

    private String orderStatus;

    private String payWay;

    private Date refundTime;

    private String refundCause;

    private String clientId;

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

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getRefundOrderId() {
        return refundOrderId;
    }

    public void setRefundOrderId(String refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    public String getOriginalOrderId() {
        return originalOrderId;
    }

    public void setOriginalOrderId(String originalOrderId) {
        this.originalOrderId = originalOrderId;
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

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public String getRefundCause() {
        return refundCause;
    }

    public void setRefundCause(String refundCause) {
        this.refundCause = refundCause;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains;
    }

    @Override
    public String toString() {
        return "BusRefund{" +
                "sysParamId=" + sysParamId +
                ", orderId='" + orderId + '\'' +
                ", refundId='" + refundId + '\'' +
                ", refundOrderId='" + refundOrderId + '\'' +
                ", originalOrderId='" + originalOrderId + '\'' +
                ", currentDiningId='" + currentDiningId + '\'' +
                ", currentDiningName='" + currentDiningName + '\'' +
                ", refundMoney=" + refundMoney +
                ", refundStatus='" + refundStatus + '\'' +
                ", auditStatus='" + auditStatus + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", payWay='" + payWay + '\'' +
                ", refundTime=" + refundTime +
                ", refundCause='" + refundCause + '\'' +
                ", clientId='" + clientId + '\'' +
                ", explains='" + explains + '\'' +
                '}';
    }
}