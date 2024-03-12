package com.mashang.xiaomishopping.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BUserEntity {

  @ApiModelProperty("主键 ID")
  private Long userId;

  @ApiModelProperty("用户名")
  private String username;

  @ApiModelProperty("密码")
  private String password;

  @ApiModelProperty("创建时间")
  private String createTime;

  @ApiModelProperty("创建人")
  private String createBy;

}
