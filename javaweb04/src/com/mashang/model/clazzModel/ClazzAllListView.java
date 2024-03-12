package com.mashang.model.clazzModel;

import java.util.List;

public class ClazzAllListView {
    // 成员变量
    // 状态码
    private Integer code = 0;

    // 数据对象
    private List<ClazzAllListInfo> data;

    // 返回内容
    private String msg = "成功";

    // Setter
    public void setCode(Integer code) {
        this.code = code;
    }

    public void setData(List<ClazzAllListInfo> data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    // Getter
    public Integer getCode() {
        return code;
    }

    public List<ClazzAllListInfo> getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}
