package com.mashang.study.view.user;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.study.entity.BUserEntity;
import lombok.Data;

@Data
public class UserInfoView {

  private Long userId;

  private String username;

  public UserInfoView transfer(BUserEntity userEntity) {
    BeanUtil.copyProperties(userEntity, this);

    return this;
  }

}
