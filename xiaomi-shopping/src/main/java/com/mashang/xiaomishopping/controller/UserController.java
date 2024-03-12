package com.mashang.xiaomishopping.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.mashang.xiaomishopping.entity.BUserEntity;
import com.mashang.xiaomishopping.service.UserService;
import com.mashang.xiaomishopping.utils.JWTUtil;
import com.mashang.xiaomishopping.view.user.UserInfoView;
import com.mashang.xiaomishopping.view.common.ResultView2;
import com.mashang.xiaomishopping.vo.user.UserLoginVo;
import com.mashang.xiaomishopping.vo.user.UserRegisterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v2/ms/user")
@Api(tags = "用户")
public class UserController {

  @Autowired
  private UserService userService;

  @ApiOperation("查询用户信息")
  @GetMapping("/info")
  public ResultView2<UserInfoView> queryUserInfo(@RequestHeader("userId") String userId) {

    return ResultView2.success(userService.userInfo(Long.valueOf(userId)));
  }

  @ApiOperation("用户登录")
  @PostMapping("/login")
  public ResultView2<String> login(@Valid @RequestBody UserLoginVo loginVo) {

    List<BUserEntity> userList = userService.userLoginList(loginVo.transfer());
    if (CollectionUtil.isEmpty(userList)) {
      return ResultView2.fail("用户名或密码错误");
    }

    BUserEntity user = userList.get(0);

    Map<String, String> paramMap = new HashMap<>();
    paramMap.put("id", user.getUserId() + "");

    String token = JWTUtil.getToken(paramMap, null);

    return ResultView2.success(token);
  }

  @ApiOperation("用户注册")
  @PostMapping("/register")
  public ResultView2 register(@Valid @RequestBody UserRegisterVo vo) {

    BUserEntity user = vo.transfer();
    user.setCreateTime(DateUtil.now());
    if (userService.register(user) == 0) return ResultView2.fail("用户名已存在");
    else return new ResultView2();

  }

}