package com.hx.entity;

import java.io.Serializable;
import java.util.List;

public class Categories implements Serializable {
    //菜单编号
    private Integer cId;
    //名字
    private String cName;
    //所属公司
    private String cCompany;
    //所属店铺
    private String cStore;
    //状态
    private Integer cStatus;
    //菜单下的商品
    private List<Goods> goods;
    //菜单的规格样式
    private List<Specification> specifications;

    public List<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specification> specifications) {
        this.specifications = specifications;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcCompany() {
        return cCompany;
    }

    public void setcCompany(String cCompany) {
        this.cCompany = cCompany;
    }

    public String getcStore() {
        return cStore;
    }

    public void setcStore(String cStore) {
        this.cStore = cStore;
    }

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
    }
    @Override
     public String toString() {
        return "Categories{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cCompany='" + cCompany + '\'' +
                ", cStore='" + cStore + '\'' +
                ", cStatus=" + cStatus +
                ", goods=" + goods +
                ", specifications=" + specifications +
                '}';
    }

}