package com.york.po;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class LendList implements Serializable {
    private Integer id;

    private Integer bookId;

    private Integer readerId;

    // 格式化接受的日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lendDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date backDate;

    private Integer backType;

    private String exceptRemarks;

    private BookInfo bookInfo;

    private ReaderInfo readerInfo;

    private static final long serialVersionUID = 1L;
}
