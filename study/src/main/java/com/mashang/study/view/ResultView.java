package com.mashang.study.view;

import lombok.Data;

import java.util.List;

@Data
public class ResultView<T> {
  private String msg;

  private Integer code;

  private T rows;

  private Integer total;

  public static ResultView success(Object rows, int total) {
    ResultView view = new ResultView();
    view.setRows(rows);
    view.setTotal(total);

    return view;
  }

}
