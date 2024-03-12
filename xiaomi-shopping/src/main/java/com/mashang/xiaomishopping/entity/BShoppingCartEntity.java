package com.mashang.xiaomishopping.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BShoppingCartEntity {

  @ApiModelProperty("数量")
  private Integer num;

  @ApiModelProperty("商品 ID")
  private Long productId;

  @ApiModelProperty("商品名称")
  private String productName;

  @ApiModelProperty("商品封面")
  private String productPicture;

  @ApiModelProperty("商品售价")
  private Double productSellingPrice;

  @ApiModelProperty("购物车 ID")
  private Long shoppingCartId;

  @ApiModelProperty("排序")
  private Integer sort;

  @ApiModelProperty("用户 ID")
  private Long userId;

}
