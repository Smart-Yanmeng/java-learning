package com.mashang.model.pub;

// Result return
public class ResultMainView<T> {
    // member
    private Integer code = 0;

    private Object data;

    private String msg = "Success";

    // setter and getter
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
