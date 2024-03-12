package com.mashang.study.vo.user;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.study.entity.BUserEntity;
import lombok.Data;

@Data
public class UserLoginVo {

  private String username;

  private String password;

  public BUserEntity transfer() {
    BUserEntity user = new BUserEntity();
    BeanUtil.copyProperties(this, user);

    return user;
  }

}
