package com.mashang.xiaomishopping.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BAreaEntity {

  @ApiModelProperty("区域 ID")
  private Long id;

  @ApiModelProperty("区域名称")
  private String name;

  @ApiModelProperty("区域父 ID")
  private Integer pid;

}
