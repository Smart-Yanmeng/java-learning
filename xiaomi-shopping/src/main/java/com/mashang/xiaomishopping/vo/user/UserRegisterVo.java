package com.mashang.xiaomishopping.vo.user;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.xiaomishopping.entity.BUserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("用户注册")
public class UserRegisterVo {

  @NotBlank
  @ApiModelProperty(value = "用户名称", required = true)
  private String username;

  @NotBlank
  @ApiModelProperty(value = "密码", required = true)
  private String password;

  public BUserEntity transfer() {
    BUserEntity user = new BUserEntity();
    BeanUtil.copyProperties(this, user);

    return user;
  }

}
