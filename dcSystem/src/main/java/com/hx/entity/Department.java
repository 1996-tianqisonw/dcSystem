package com.hx.entity;

public class Department {
    private Integer departmentId;

    private String departmentName;

    private String company;

    private String store;

    private String position;

    private String departmentAdd;

    private String orgName;

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

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", company='" + company + '\'' +
                ", store='" + store + '\'' +
                ", position='" + position + '\'' +
                ", departmentAdd='" + departmentAdd + '\'' +
                ", orgName='" + orgName + '\'' +
                '}';
    }
}