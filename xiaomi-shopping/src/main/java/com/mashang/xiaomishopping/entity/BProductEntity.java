package com.mashang.xiaomishopping.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BProductEntity {

  @ApiModelProperty("分类 ID")
  private Integer categoryId;

  @ApiModelProperty("分类")
  private String categoryName;

  @ApiModelProperty("商品 ID")
  private Integer productId;

  @ApiModelProperty("商品简介")
  private String productIntro;

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

  @ApiModelProperty("创建人")
  private String createBy;

  @ApiModelProperty("排序")
  private Integer sort;

}
