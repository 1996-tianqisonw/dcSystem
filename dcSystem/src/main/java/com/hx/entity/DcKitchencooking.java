package com.hx.entity;

import java.io.Serializable;

public class DcKitchencooking implements Serializable {
    private String kcOrdernumber;

    private String kcPicture;

    private String kcKitchenname;

    private Integer kcPlaceorder;

    private Integer kcBacksingular;

    private Integer kcRmeountshould;

    private Integer kcCooking;

    private String kcOrdertime;

    private String kcOperation;

    public String getKcOrdernumber() {
        return kcOrdernumber;
    }

    public void setKcOrdernumber(String kcOrdernumber) {
        this.kcOrdernumber = kcOrdernumber;
    }

    public String getKcPicture() {
        return kcPicture;
    }

    public void setKcPicture(String kcPicture) {
        this.kcPicture = kcPicture;
    }

    public String getKcKitchenname() {
        return kcKitchenname;
    }

    public void setKcKitchenname(String kcKitchenname) {
        this.kcKitchenname = kcKitchenname;
    }

    public Integer getKcPlaceorder() {
        return kcPlaceorder;
    }

    public void setKcPlaceorder(Integer kcPlaceorder) {
        this.kcPlaceorder = kcPlaceorder;
    }

    public Integer getKcBacksingular() {
        return kcBacksingular;
    }

    public void setKcBacksingular(Integer kcBacksingular) {
        this.kcBacksingular = kcBacksingular;
    }

    public Integer getKcRmeountshould() {
        return kcRmeountshould;
    }

    public void setKcRmeountshould(Integer kcRmeountshould) {
        this.kcRmeountshould = kcRmeountshould;
    }

    public Integer getKcCooking() {
        return kcCooking;
    }

    public void setKcCooking(Integer kcCooking) {
        this.kcCooking = kcCooking;
    }

    public String getKcOrdertime() {
        return kcOrdertime;
    }

    public void setKcOrdertime(String kcOrdertime) {
        this.kcOrdertime = kcOrdertime;
    }

    public String getKcOperation() {
        return kcOperation;
    }

    public void setKcOperation(String kcOperation) {
        this.kcOperation = kcOperation;
    }

    @Override
    public String toString() {
        return "DcKitchencooking{" +
                "kcOrdernumber='" + kcOrdernumber + '\'' +
                ", kcPicture='" + kcPicture + '\'' +
                ", kcKitchenname='" + kcKitchenname + '\'' +
                ", kcPlaceorder=" + kcPlaceorder +
                ", kcBacksingular=" + kcBacksingular +
                ", kcRmeountshould=" + kcRmeountshould +
                ", kcCooking=" + kcCooking +
                ", kcOrdertime='" + kcOrdertime + '\'' +
                ", kcOperation='" + kcOperation + '\'' +
                '}';
    }
}