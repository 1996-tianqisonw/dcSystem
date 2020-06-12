package com.hx.util;

import java.util.List;

public class CategoriesTree {
    Integer id;
    String text;
    List<CategoriesTree> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<CategoriesTree> getChildren() {
        return children;
    }

    public void setChildren(List<CategoriesTree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", children=" + children +
                '}';
    }
}
