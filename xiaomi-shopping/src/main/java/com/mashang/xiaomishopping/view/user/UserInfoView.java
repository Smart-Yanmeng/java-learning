package com.mashang.xiaomishopping.view.user;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.xiaomishopping.entity.BUserEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserInfoView {

  @ApiModelProperty("用户 ID")
  private Long userId;

  @ApiModelProperty("用户名")
  private String username;

  public UserInfoView transfer(BUserEntity userEntity) {
    BeanUtil.copyProperties(userEntity, this);

    return this;
  }

}
