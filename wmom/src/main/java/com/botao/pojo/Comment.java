package com.botao.pojo;

import java.util.Date;

public class Comment {
    private String id;
    private String productid;
    private String username;
    private String text;
    private Date created;
    private Date deleted;

    public Comment() {
    }

    public Comment(String id, String productid, String username, String text, Date created, Date deleted) {
        this.id = id;
        this.productid = productid;
        this.username = username;
        this.text = text;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
