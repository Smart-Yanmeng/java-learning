package com.mashang.xiaomishopping.vo.shoppingcartproduct;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.xiaomishopping.entity.BProductEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ShoppingCartProductVo {

  @ApiModelProperty("商品 ID")
  private Long productId;

  @ApiModelProperty("用户 ID")
  private Long userId;

  @ApiModelProperty("商品名称")
  private String productName;

  @ApiModelProperty("商品封面")
  private String productPicture;

  @ApiModelProperty("商品售价")
  private Double productSellingPrice;

  @ApiModelProperty("商品数量")
  private Integer num;

  public ShoppingCartProductVo transfer(BProductEntity product) {
    BeanUtil.copyProperties(product, this);

    return this;
  }

}
