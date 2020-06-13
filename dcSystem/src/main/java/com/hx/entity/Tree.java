package com.hx.entity;

import java.util.List;

public class Tree {
    private Integer menuId;

    private String menuName;

    private String url;

    private String permissions;

    private Integer orgId;

    private String type;

    private String staste;

    private String sorting;

    private Boolean checked;

    private List<Tree> children;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStaste() {
        return staste;
    }

    public void setStaste(String staste) {
        this.staste = staste;
    }

    public String getSorting() {
        return sorting;
    }

    public void setSorting(String sorting) {
        this.sorting = sorting;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", url='" + url + '\'' +
                ", permissions='" + permissions + '\'' +
                ", orgId=" + orgId +
                ", type='" + type + '\'' +
                ", state='" + staste + '\'' +
                ", sorting='" + sorting + '\'' +
                ", checked=" + checked +
                ", children=" + children +
                '}';
    }
}
