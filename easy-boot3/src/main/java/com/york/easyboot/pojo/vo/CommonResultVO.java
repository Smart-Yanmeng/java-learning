package com.york.easyboot.pojo.vo;

import lombok.Data;

@Data
public class CommonResultVO {

    private Integer code;

    private String message;

    private Object data;
}
