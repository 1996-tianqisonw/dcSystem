package com.hx.entity;

import java.util.Date;

public class TableState {
    private String dtId;

    private String dtUsername;

    private String dtMobilephonenumber;

    private Date dtStarttime;

    private Date dtEndtime;

    private String dtNote;

    private Date dtCreatetime;

    private Date dtNewtime;

    private String dtUpdatereason;

    private Integer dtEnvironment;

    private String dtEnvironmentText;

    public String getDtEnvironmentText() {
        return dtEnvironmentText;
    }

    public void setDtEnvironmentText(String dtEnvironmentText) {
        this.dtEnvironmentText = dtEnvironmentText;
    }

    public String getDtId() {
        return dtId;
    }

    public void setDtId(String dtId) {
        this.dtId = dtId;
    }

    public String getDtUsername() {
        return dtUsername;
    }

    public void setDtUsername(String dtUsername) {
        this.dtUsername = dtUsername;
    }

    public String getDtMobilephonenumber() {
        return dtMobilephonenumber;
    }

    public void setDtMobilephonenumber(String dtMobilephonenumber) {
        this.dtMobilephonenumber = dtMobilephonenumber;
    }

    public Date getDtStarttime() {
        return dtStarttime;
    }

    public void setDtStarttime(Date dtStarttime) {
        this.dtStarttime = dtStarttime;
    }

    public Date getDtEndtime() {
        return dtEndtime;
    }

    public void setDtEndtime(Date dtEndtime) {
        this.dtEndtime = dtEndtime;
    }

    public String getDtNote() {
        return dtNote;
    }

    public void setDtNote(String dtNote) {
        this.dtNote = dtNote;
    }

    public Date getDtCreatetime() {
        return dtCreatetime;
    }

    public void setDtCreatetime(Date dtCreatetime) {
        this.dtCreatetime = dtCreatetime;
    }

    public Date getDtNewtime() {
        return dtNewtime;
    }

    public void setDtNewtime(Date dtNewtime) {
        this.dtNewtime = dtNewtime;
    }

    public String getDtUpdatereason() {
        return dtUpdatereason;
    }

    public void setDtUpdatereason(String dtUpdatereason) {
        this.dtUpdatereason = dtUpdatereason;
    }

    public Integer getDtEnvironment() {
        return dtEnvironment;
    }

    public void setDtEnvironment(Integer dtEnvironment) {
        this.dtEnvironment = dtEnvironment;
    }
}