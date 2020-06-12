package com.hx.entity;

import java.io.Serializable;
import java.util.Date;

public class DcTablemanagement implements Serializable {
    private String dcId;

    private String shopCartId;

    private String dcName;

    private Integer dcSpecifications;

    private String dcShop;

    private String dcCompanies;

    private Integer dcForm;

    private Integer dcUsestatus;

    private Date dcCreatetime;

    private Date dcUpdatetime;

    private String dcUpdatereason;

    private String dcQrcode;

    private BusShopCart busShopCart;

    public BusShopCart getBusShopCart() {
        return busShopCart;
    }

    public void setBusShopCart(BusShopCart busShopCart) {
        this.busShopCart = busShopCart;
    }

    public String getDcId() {
        return dcId;
    }

    public void setDcId(String dcId) {
        this.dcId = dcId;
    }

    public String getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(String shopCartId) {
        this.shopCartId = shopCartId;
    }

    public String getDcName() {
        return dcName;
    }

    public void setDcName(String dcName) {
        this.dcName = dcName;
    }

    public Integer getDcSpecifications() {
        return dcSpecifications;
    }

    public void setDcSpecifications(Integer dcSpecifications) {
        this.dcSpecifications = dcSpecifications;
    }

    public String getDcShop() {
        return dcShop;
    }

    public void setDcShop(String dcShop) {
        this.dcShop = dcShop;
    }

    public String getDcCompanies() {
        return dcCompanies;
    }

    public void setDcCompanies(String dcCompanies) {
        this.dcCompanies = dcCompanies;
    }

    public Integer getDcForm() {
        return dcForm;
    }

    public void setDcForm(Integer dcForm) {
        this.dcForm = dcForm;
    }

    public Integer getDcUsestatus() {
        return dcUsestatus;
    }

    public void setDcUsestatus(Integer dcUsestatus) {
        this.dcUsestatus = dcUsestatus;
    }

    public Date getDcCreatetime() {
        return dcCreatetime;
    }

    public void setDcCreatetime(Date dcCreatetime) {
        this.dcCreatetime = dcCreatetime;
    }

    public Date getDcUpdatetime() {
        return dcUpdatetime;
    }

    public void setDcUpdatetime(Date dcUpdatetime) {
        this.dcUpdatetime = dcUpdatetime;
    }

    public String getDcUpdatereason() {
        return dcUpdatereason;
    }

    public void setDcUpdatereason(String dcUpdatereason) {
        this.dcUpdatereason = dcUpdatereason;
    }

    public String getDcQrcode() {
        return dcQrcode;
    }

    public void setDcQrcode(String dcQrcode) {
        this.dcQrcode = dcQrcode;
    }

    @Override
    public String toString() {
        return "DcTablemanagement{" +
                "dcId='" + dcId + '\'' +
                ", shopCartId='" + shopCartId + '\'' +
                ", dcName='" + dcName + '\'' +
                ", dcSpecifications=" + dcSpecifications +
                ", dcShop='" + dcShop + '\'' +
                ", dcCompanies='" + dcCompanies + '\'' +
                ", dcForm=" + dcForm +
                ", dcUsestatus=" + dcUsestatus +
                ", dcCreatetime=" + dcCreatetime +
                ", dcUpdatetime=" + dcUpdatetime +
                ", dcUpdatereason='" + dcUpdatereason + '\'' +
                ", dcQrcode='" + dcQrcode + '\'' +
                ", busShopCart=" + busShopCart +
                '}';
    }
}