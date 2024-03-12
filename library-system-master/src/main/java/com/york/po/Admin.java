package com.york.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class Admin implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private Integer adminType;

    private static final long serialVersionUID = 1L;

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}
