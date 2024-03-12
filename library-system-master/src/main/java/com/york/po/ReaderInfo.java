package com.york.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ReaderInfo implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String realName;

    private String sex;

    private Date birthday;

    private String address;

    private String tel;

    private String email;

    private Date registerDate;

    private String readerNumber;

    private static final long serialVersionUID = 1L;

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public void setReaderNumber(String readerNumber) {
        this.readerNumber = readerNumber == null ? null : readerNumber.trim();
    }
}
