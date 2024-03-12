package com.mashang.xiaomishopping.view.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResultView2<T> {

  @ApiModelProperty("消息状态码")
  private Integer code = 200;

  @ApiModelProperty("数据列表")
  private T data;

  @ApiModelProperty("返回信息")
  private String msg = "success";

  public static ResultView2 success(Object data) {
    ResultView2 view = new ResultView2();
    view.setData(data);

    return view;
  }

  public static ResultView2 fail(Integer code, String msg) {
    ResultView2 view = new ResultView2();
    view.setCode(code);
    view.setMsg(msg);

    return view;
  }

  public static ResultView2 fail() {
    ResultView2 view = new ResultView2();
    view.setCode(500);
    view.setMsg("登录出错，请联系管理员");

    return view;
  }

  public static ResultView2 fail(String msg) {
    ResultView2 view = new ResultView2();
    view.setCode(500);
    view.setMsg(msg);

    return view;
  }

}
