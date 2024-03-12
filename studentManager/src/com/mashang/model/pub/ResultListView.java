package com.mashang.model.pub;

import java.util.List;

// List result return
public class ResultListView<T> {
    // member
    private Integer code = 0;

    private String msg = "Success";

    private List<T> rows;

    private Integer total;

    // Setter and Getter
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
