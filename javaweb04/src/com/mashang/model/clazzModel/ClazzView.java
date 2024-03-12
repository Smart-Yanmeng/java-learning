package com.mashang.model.clazzModel;

public class ClazzView {
    private Integer code = 0;

    private String msg = "操作成功";

    private Data data;

    // Setter
    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Data data) {
        this.data = data;
    }

    // Getter
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Data getData() {
        return data;
    }
}
