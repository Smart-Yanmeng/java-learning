package com.york.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class TypeInfo implements Serializable {

    private Integer id;

    private String name;

    private String remarks;

    private static final long serialVersionUID = 1L;

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
