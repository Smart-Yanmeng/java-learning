package com.mashang.model.clazz;

import com.mashang.sevlet.clazz.ClazzAllList;

import java.util.List;

public class ResultAllListView {
    // member
    private Integer code = 0;

    private List<ClazzAllListInfo> data;

    private String msg = "Success";

    // setter and getter
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<ClazzAllListInfo> getData() {
        return data;
    }

    public void setData(List<ClazzAllListInfo> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
