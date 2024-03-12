package com.mashang.xiaomishopping.view.product;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.xiaomishopping.entity.BHotProductEntity;
import com.mashang.xiaomishopping.entity.BProductEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class HotProductListView {

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

  public HotProductListView transfer(BHotProductEntity hotProduct) {
    BeanUtil.copyProperties(hotProduct, this);

    return this;
  }

}
