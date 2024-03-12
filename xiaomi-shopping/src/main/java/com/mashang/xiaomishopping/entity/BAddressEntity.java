package com.mashang.xiaomishopping.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class  BAddressEntity {

  @ApiModelProperty("用户主键 ID")
  private Long userId;

  @ApiModelProperty("地址 ID")
  private Long addressId;

  @ApiModelProperty("标签")
  private String addressTags;

  @ApiModelProperty("详细信息")
  private String addressDtl;

  @ApiModelProperty("区域信息")
  private String area;

  @ApiModelProperty("收货人姓名")
  private String name;

  @ApiModelProperty("收货人电话号码")
  private String phone;

  @ApiModelProperty("创建时间")
  private String createTime;

  @ApiModelProperty("排序")
  private Integer sort;

}
