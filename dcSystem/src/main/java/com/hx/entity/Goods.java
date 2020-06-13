package com.hx.entity;


import java.io.Serializable;

public class Goods implements Serializable {
    //商品id
    private Integer goodsId;
    //商品名字
    private String goodsName;
    //商品标题
    private String goodsTitle;
    //编号
    private String goodsNo;
    //图片
    private String goodsImg;
    //价格
    private Integer goodsPrice;
    //状态
    private Integer goodsStatus;

    /*    @DateTimeFormat(pattern = "yyyy-MM-dd") //入参

        @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd") //出参*/
    //添加时间
    private String addTime;
    //规格样式
    private String specification;
    //商品描述
    private String goodsDescriptive;

    private Categories categories;

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Categories getCategories() {
        return categories;
    }

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

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
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
    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsNo='" + goodsNo + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsStatus=" + goodsStatus +
                ", addTime=" + addTime +
                ", specification='" + specification + '\'' +
                ", goodsDescriptive='" + goodsDescriptive + '\'' +
                ", categories=" + categories +
                '}';
    }
}