package com.mashang.xiaomishopping.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BOrderProductEntity {

  @ApiModelProperty("订单 ID")
  private Long orderId;

  @ApiModelProperty("数量")
  private Integer num;

  @ApiModelProperty("订单详情 ID")
  private Long orderDtlId;

  @ApiModelProperty("商品 ID")
  private Long productId;

  @ApiModelProperty("商品名称")
  private String productName;

  @ApiModelProperty("商品封面")
  private String productPicture;

  @ApiModelProperty("商品售价")
  private Double productSellingPrice;

  @ApiModelProperty("排序")
  private Integer sort;

}
