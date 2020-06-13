package com.hx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserDept {

    private Integer userId;

    private String userName;

    private String userPassword;

    private String name;

    private Integer departmentId;

    private String departmentName;

    private String company;

    private String store;

    private String position;

    private String departmentAdd;

    private String orgName;

    private String state;

    private String phone;

    private String work;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date onjob;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date departure;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartmentAdd() {
        return departmentAdd;
    }

    public void setDepartmentAdd(String departmentAdd) {
        this.departmentAdd = departmentAdd;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Date getOnjob() {
        return onjob;
    }

    public void setOnjob(Date onjob) {
        this.onjob = onjob;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    @Override
    public String toString() {
        return "UserDept{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", name='" + name + '\'' +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", company='" + company + '\'' +
                ", store='" + store + '\'' +
                ", position='" + position + '\'' +
                ", departmentAdd='" + departmentAdd + '\'' +
                ", orgName='" + orgName + '\'' +
                ", state='" + state + '\'' +
                ", phone='" + phone + '\'' +
                ", work='" + work + '\'' +
                ", onjob=" + onjob +
                ", departure=" + departure +
                '}';
    }
}
