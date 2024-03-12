package com.example.geek_navigation.domain.vo;

import lombok.Data;

@Data
public class ResultVo<T> {
    private Integer code;

    private String message;

    private T data;

    public ResultVo(int code, String msg, T type) {
        this.code = code;
        this.message = msg;
        this.data = type;
    }
}
