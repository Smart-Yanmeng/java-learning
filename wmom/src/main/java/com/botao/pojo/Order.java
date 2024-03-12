package com.botao.pojo;

import java.util.Date;

public class Order {
    private String id;
    private String productid;
    private String userid;
    private Integer number;
    private String addr;
    private Integer status;
    private Date created;
    private Date deleted;

    public Order() {
    }

    public Order(String id, String productid, String userid, Integer number, String addr, Integer status, Date created, Date deleted) {
        this.id = id;
        this.productid = productid;
        this.userid = userid;
        this.number = number;
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

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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
