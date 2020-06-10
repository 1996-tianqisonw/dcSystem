package com.hx.entity;

/**
 * Created by admin on 2020/5/26.
 */
public class Parameter {
    private String field;
    private String value;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "field='" + field + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
