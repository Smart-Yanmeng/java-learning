package com.mashang.xiaomishopping.view.product;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.xiaomishopping.entity.BProductEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProductListView {

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

  public ProductListView transfer(BProductEntity product) {
    BeanUtil.copyProperties(product, this);

    return this;
  }
}
