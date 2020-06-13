package com.hx.entity;

import java.io.Serializable;

public class Specification implements Serializable {
    //规格id
    private Integer sId;
    //规格名字
    private String sName;
    //规格样式
    private String sStyle;
    //状态
    private Integer sStatus;

    private Categories categories;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsStyle() {
        return sStyle;
    }

    public void setsStyle(String sStyle) {
        this.sStyle = sStyle;
    }

    public Integer getsStatus() {
        return sStatus;
    }

    public void setsStatus(Integer sStatus) {
        this.sStatus = sStatus;
    }

    @Override
    public String toString() {
        return "Specification{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sStyle='" + sStyle + '\'' +
                ", sStatus=" + sStatus +
                ", categories=" + categories +
                '}';
    }
}