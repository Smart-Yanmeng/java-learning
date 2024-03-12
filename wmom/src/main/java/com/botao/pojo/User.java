package com.botao.pojo;

import java.util.Date;

public class User {
    private String id;
    private String username;
    private String name;
    private String password;
    private String phone;
    private String head;
    private String addr;
    private Integer status;
    private Date created;
    private Date deleted;

    public User() {
    }

    public User(String id, String username, String name, String password, String phone, String head, String addr, Integer status, Date created, Date deleted) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.head = head;
        this.addr = addr;
        this.status = status;
        this.created = created;
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
}
