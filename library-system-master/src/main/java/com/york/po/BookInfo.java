package com.york.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BookInfo implements Serializable {

    private Integer id;

    private String name;

    private String author;

    private String publish;

    private String isbn;

    private String introduction;

    private String language;

    private Double price;

    private Date publishDate;

    private Integer typeId;

    private Integer status;

    // 图书类型
    private TypeInfo typeInfo;

    private Integer counts;

    private static final long serialVersionUID = 1L;

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public void setPublish(String publish) {
        this.publish = publish == null ? null : publish.trim();
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }
}
