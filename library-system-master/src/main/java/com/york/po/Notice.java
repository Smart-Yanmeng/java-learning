package com.york.po;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Notice implements Serializable {

    private Integer id;

    private String topic;

    private String content;

    private String author;

    // 格式化接收到的时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    private static final long serialVersionUID = 1L;

    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }
}
