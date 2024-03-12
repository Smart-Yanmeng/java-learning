package com.botao.pojo;

import java.util.Date;

public class Cart {
    private String id;
    private String productid;
    private String userid;
    private Date created;
    private Date deleted;

    public Cart() {
    }

    public Cart(String id, String productid, String userid, Date created, Date deleted) {
        this.id = id;
        this.productid = productid;
        this.userid = userid;
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
