package com.hx.entity;

import java.util.Date;

public class Table {
    private String dcId;

    private String dcName;

    private Integer dcSpecifications;

    private String dcSpecificationsText;

    private String dcShop;

    private String dcCompanies;

    private Integer dcForm;

    private String dcFormText;

    private Integer dcUsestatus;

    private String dcUsestatusText;

    private Date dcCreatetime;

    private Date dcUpdatetime;

    private String dcUpdatereason;

    private String dcQrcode;

    public String getDcSpecificationsText() {
        return dcSpecificationsText;
    }

    public void setDcSpecificationsText(String dcSpecificationsText) {
        this.dcSpecificationsText = dcSpecificationsText;
    }

    public String getDcFormText() {
        return dcFormText;
    }

    public void setDcFormText(String dcFormText) {
        this.dcFormText = dcFormText;
    }

    public String getDcUsestatusText() {
        return dcUsestatusText;
    }

    public void setDcUsestatusText(String dcUsestatusText) {
        this.dcUsestatusText = dcUsestatusText;
    }

    public String getDcId() {
        return dcId;
    }

    public void setDcId(String dcId) {
        this.dcId = dcId;
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
}