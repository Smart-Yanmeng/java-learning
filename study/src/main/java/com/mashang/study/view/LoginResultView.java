package com.mashang.study.view;

import lombok.Data;

@Data
public class LoginResultView {
  String msg;

  Integer code;

  String token;

  public static LoginResultView fail() {
    LoginResultView view = new LoginResultView();
    view.setCode(500);
    view.setMsg("登录出错，请联系管理员");

    return view;
  }

  public static LoginResultView fail(String msg) {
    LoginResultView view = new LoginResultView();
    view.setCode(500);
    view.setMsg(msg);

    return view;
  }

}
