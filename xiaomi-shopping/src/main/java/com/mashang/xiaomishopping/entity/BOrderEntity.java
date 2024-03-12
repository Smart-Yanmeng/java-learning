package com.mashang.xiaomishopping.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BOrderEntity {

  @ApiModelProperty("用户 ID")
  private Long userId;

  @ApiModelProperty("详细地址")
  private String addressDtl;

  @ApiModelProperty("标签")
  private String addressTags;

  @ApiModelProperty("收货人姓名")
  private String addressee;

  @ApiModelProperty("区域信息")
  private String addresseeArea;

  @ApiModelProperty("收货人电话号码")
  private String addresseePhone;

  @ApiModelProperty("订单 ID")
  private Long orderId;

  @ApiModelProperty("订单号")
  private String orderNum;

  @ApiModelProperty("订单时间")
  private String orderTime;

  @ApiModelProperty("排序")
  private Integer sort;

}
