package com.mashang.model.clazzModel;

import java.util.List;

public class ClazzListView {
    //    状态码
    private Integer code;

    //    数据对象
    private List<ClazzListInfo> rows;

    //    返回内容
    private String msg;

    //    Setter
    public void setCode(Integer code) {
        this.code = code;
    }

    public void setRows(List<ClazzListInfo> rows) {
        this.rows = rows;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    //    Getter
    public Integer getCode() {
        return code;
    }

    public List<ClazzListInfo> getRows() {
        return rows;
    }

    public String getMsg() {
        return msg;
    }
}
