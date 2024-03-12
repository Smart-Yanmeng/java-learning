package com.mashang.model;

import com.mashang.model.clazzModel.ClazzListInfo;

import java.util.List;

public class ResultListView<T> {
    //    消息状态码
    private Integer code = 0;

    //    消息内容
    private String msg = "操作成功";

    //    总记录数
    private Integer total;

    //    列表数据
    private List<T> rows;

    //    Setter
    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    //    Getter
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getTotal() {
        return total;
    }

    public List<T> getRows() {
        return rows;
    }
}
