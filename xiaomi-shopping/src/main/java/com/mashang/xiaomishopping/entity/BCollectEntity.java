package com.mashang.xiaomishopping.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BCollectEntity {

  @ApiModelProperty("用户 ID")
  private Long userId;

  @ApiModelProperty("收藏 ID")
  private Long collectId;

  @ApiModelProperty("商品 ID")
  private Long productId;

  @ApiModelProperty("商品名称")
  private String productName;

  @ApiModelProperty("商品封面")
  private String productPicture;

  @ApiModelProperty("商品原价")
  private Double productPrice;

  @ApiModelProperty("商品售价")
  private Double productSellingPrice;

  @ApiModelProperty("商品标题")
  private String productTitle;

  @ApiModelProperty("创建时间")
  private String createTime;

}
