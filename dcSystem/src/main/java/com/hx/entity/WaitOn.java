package com.hx.entity;

public class WaitOn {
    private Integer onOffId;

    private Integer dpId;

    private String onOffState;//店铺排队功能，0不启用；1启用

    private String createTime;
    private String stateName;

    private String updateTime;

    private Integer updatePeple;
    public String getStateName() {
        if("1".equals(onOffState)){
            return "启用";
        }
        return "不启用";
    }

    public Integer getOnOffId() {
        return onOffId;
    }

    public void setOnOffId(Integer onOffId) {
        this.onOffId = onOffId;
    }

    public Integer getDpId() {
        return dpId;
    }

    public void setDpId(Integer dpId) {
        this.dpId = dpId;
    }

    public String getOnOffState() {
        return onOffState;
    }

    public void setOnOffState(String onOffState) {
        this.onOffState = onOffState;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdatePeple() {
        return updatePeple;
    }

    public void setUpdatePeple(Integer updatePeple) {
        this.updatePeple = updatePeple;
    }
}