package com.mashang.study.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.mashang.study.entity.BUserEntity;
import com.mashang.study.service.UserService;
import com.mashang.study.utils.JWTUtil;
import com.mashang.study.view.LoginResultView;
import com.mashang.study.vo.user.UserLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student_manager/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/user/login")
  public LoginResultView login(@Valid @RequestBody UserLoginVo loginVo) {

    List<BUserEntity> userList = userService.userLoginList(loginVo.transfer());
    if (CollectionUtil.isEmpty(userList)) {
      return LoginResultView.fail("用户名或密码错误");
    }

    BUserEntity user = userList.get(0);

    Map<String, String> paramMap = new HashMap<>();
    paramMap.put("id", user.getUserId() + "");

    String token = JWTUtil.getToken(paramMap, null);

    return null;
  }

}
