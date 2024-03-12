package com.mashang.xiaomishopping.vo.order;

import com.mashang.xiaomishopping.entity.BAddressEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderVo {

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
  private String addressPhone;

  @ApiModelProperty("订单 ID")
  private Long orderId;

  @ApiModelProperty("订单编号")
  private String orderNum;

  @ApiModelProperty("订单时间")
  private String orderTime;

  public OrderVo transfer(BAddressEntity address) {
    this.userId = address.getUserId();
    this.addressDtl = address.getAddressDtl();
    this.addressTags = address.getAddressTags();
    this.addressee = address.getName();
    this.addresseeArea = address.getArea();
    this.addressPhone = address.getPhone();

    return this;
  }

}
