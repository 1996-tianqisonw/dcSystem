package com.hx.entity;


public class CusCall {
    private Integer callId;

    private Integer dpId;

    private Integer czId;

    private String czName;

    private String custId;//对应客人信息，推送消息时用

    private String callText;

    private String dealState;//0未处理；1已处理

    private String stateName;//翻译获取状态的内容

    private String beginTime;

    private String dealTime;

    private Integer dealPepleId;

    private String[] ids;//辅助删除多行数据

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public String getStateName() {
        if("0".equals(dealState)){
            return "未处理";
        }
        return "已处理";
    }
    public Integer getCallId() {
        return callId;
    }

    public void setCallId(Integer callId) {
        this.callId = callId;
    }

    public Integer getDpId() {
        return dpId;
    }

    public void setDpId(Integer dpId) {
        this.dpId = dpId;
    }

    public Integer getCzId() {
        return czId;
    }

    public void setCzId(Integer czId) {
        this.czId = czId;
    }

    public String getCzName() {
        return czName;
    }

    public void setCzName(String czName) {
        this.czName = czName;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustId() {

        return custId;
    }

    public String getCallText() {
        return callText;
    }

    public void setCallText(String callText) {
        this.callText = callText;
    }

    public String getDealState() {
        return dealState;
    }

    public void setDealState(String dealState) {
        this.dealState = dealState;
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

    public Integer getDealPepleId() {
        return dealPepleId;
    }

    public void setDealPepleId(Integer dealPepleId) {
        this.dealPepleId = dealPepleId;
    }

    @Override
    public String toString() {
        return "CusCall{" +
                "callId=" + callId +
                ", dpId=" + dpId +
                ", czId=" + czId +
                ", czName='" + czName + '\'' +
                ", callText='" + callText + '\'' +
                ", dealState='" + dealState + '\'' +
                ", beginTime=" + beginTime +
                ", dealTime=" + dealTime +
                ", dealPepleId=" + dealPepleId +
                '}';
    }
}