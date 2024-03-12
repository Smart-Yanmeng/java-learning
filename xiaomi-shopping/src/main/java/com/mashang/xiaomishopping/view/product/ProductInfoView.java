package com.mashang.xiaomishopping.view.product;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.xiaomishopping.entity.BProductInfoEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductInfoView<T> {

  @ApiModelProperty("分类 ID")
  private Integer categoryId;

  @ApiModelProperty("分类")
  private String categoryName;

  @ApiModelProperty("是否已经收藏")
  private Integer isCollect;

  @ApiModelProperty("商品图片")
  private List<T> pictures;

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

  public ProductInfoView<T> transfer(BProductInfoEntity productInfo) {
    BeanUtil.copyProperties(productInfo, this);

    return this;
  }

}
