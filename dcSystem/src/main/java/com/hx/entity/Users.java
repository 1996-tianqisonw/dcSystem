package com.hx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Users {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String name;

    private Integer departmentId;

    private String state;

    private String phone;

    private String work;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date onjob;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date departure;

    private Role roles;

    private Department department;

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

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", name='" + name + '\'' +
                ", departmentId=" + departmentId +
                ", state='" + state + '\'' +
                ", phone='" + phone + '\'' +
                ", work='" + work + '\'' +
                ", onjob=" + onjob +
                ", departure=" + departure +
                ", roles=" + roles +
                ", department=" + department +
                '}';
    }
}