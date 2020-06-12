package com.hx.entity;

import java.io.Serializable;
import java.util.Date;

public class GoodsCategories implements Serializable {

    private Integer goodsId;

    private String goodsName;

    private String goodsTitle;

    private String goodsNo;

    private String goodsImg;

    private Float goodsPrice;

    private String goodsStatus;

    private String addTime;

    private String specification;

    private String goodsDescriptive;

    private String cName;
    //所属公司
    private String cCompany;
    //所属店铺
    private String cStore;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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

    public Float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getGoodsDescriptive() {
        return goodsDescriptive;
    }

    public void setGoodsDescriptive(String goodsDescriptive) {
        this.goodsDescriptive = goodsDescriptive;
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



}
