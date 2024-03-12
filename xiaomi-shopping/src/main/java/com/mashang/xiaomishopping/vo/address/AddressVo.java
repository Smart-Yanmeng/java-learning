package com.mashang.xiaomishopping.vo.address;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("收货地址")
public class AddressVo {

  @ApiModelProperty("地址 ID")
  private Long addressId;

  @ApiModelProperty("用户 ID")
  private Long userId;

  @ApiModelProperty("详细地址")
  private String addressDtl;

  @ApiModelProperty("标签")
  private String addressTags;

  @ApiModelProperty("区域信息")
  private String area;

  @ApiModelProperty("收货人姓名")
  private String name;

  @ApiModelProperty("收货人电话号码")
  private String phone;

}
