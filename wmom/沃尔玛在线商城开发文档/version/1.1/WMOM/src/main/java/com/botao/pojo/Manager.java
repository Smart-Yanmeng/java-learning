package com.botao.pojo;

import java.util.Date;

/**
 * @author cbt28
 */
public class Manager {
    private String id;
    private String username;
    private String password;
    private String name;
    private Date created;
    private Date deleted;

    public Manager() {
    }

    public Manager(String id, String username, String password, String name, Date created, Date deleted) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
