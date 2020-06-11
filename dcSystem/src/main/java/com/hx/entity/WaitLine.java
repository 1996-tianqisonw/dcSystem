package com.hx.entity;

public class WaitLine {
    private Integer lineId;

    private Integer dpId;

    private String custName;

    private String custTel;

    private String lineXh;//记录排队序号，@代表号序继续递增#代表号序终断，从1开始

    private Integer pepleNum;

    private String lineState;//0排队中；1已就餐；2客户中途取消；3已过号
    private String stateName;//翻译获取状态的内容
    public String getStateName() {
        if("0".equals(lineState)){
            return "排队中";
        } else if("1".equals(lineState)){
            return "已就餐";
        }else if("2".equals(lineState)){
            return "客户中途取消";
        }else if("3".equals(lineState)){
            return "已过号";
        } else {return "未知";}
    }
    private String beginTime;

    private String dealTime;

    private Integer dealBy;

    private String lineRemarks;

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public Integer getDpId() {
        return dpId;
    }

    public void setDpId(Integer dpId) {
        this.dpId = dpId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getLineXh() {
        return lineXh;
    }

    public void setLineXh(String lineXh) {
        this.lineXh = lineXh;
    }

    public Integer getPepleNum() {
        return pepleNum;
    }

    public void setPepleNum(Integer pepleNum) {
        this.pepleNum = pepleNum;
    }

    public String getLineState() {
        return lineState;
    }

    public void setLineState(String lineState) {
        this.lineState = lineState;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public Integer getDealBy() {
        return dealBy;
    }

    public void setDealBy(Integer dealBy) {
        this.dealBy = dealBy;
    }

    public void setLineRemarks(String lineRemarks) {
        this.lineRemarks = lineRemarks;
    }
    public String getLineRemarks() {
        return lineRemarks;
    }

    public void setCustTel(String custTel) {
        this.custTel = custTel;
    }

    public String getCustTel() {
        return custTel;

    }

    @Override
    public String toString() {
        return "WaitLine{" +
                "lineId=" + lineId +
                ", dpId=" + dpId +
                ", custName='" + custName + '\'' +
                ", lineXh='" + lineXh + '\'' +
                ", pepleNum=" + pepleNum +
                ", lineState='" + lineState + '\'' +
                ", beginTime=" + beginTime +
                ", dealTime=" + dealTime +
                ", dealBy=" + dealBy +
                ", lineRemarks='" + lineRemarks + '\'' +
                '}';
    }
}