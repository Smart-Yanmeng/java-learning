package com.mashang.xiaomishopping.view.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResultView1<T> {

  @ApiModelProperty("消息状态码")
  private Integer code = 200;

  @ApiModelProperty("消息内容")
  private String msg = "success";

  @ApiModelProperty("数据列表")
  private T rows;

  @ApiModelProperty("总记录数")
  private Integer total;

  public static ResultView1 success(Object rows, int total) {
    ResultView1 view = new ResultView1();
    view.setRows(rows);
    view.setTotal(total);

    return view;
  }

}
