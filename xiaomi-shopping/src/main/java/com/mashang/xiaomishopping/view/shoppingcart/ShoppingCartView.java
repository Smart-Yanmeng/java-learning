package com.mashang.xiaomishopping.view.shoppingcart;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.xiaomishopping.entity.BShoppingCartEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ShoppingCartView {

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

  public ShoppingCartView transfer(BShoppingCartEntity shoppingEntity) {
    BeanUtil.copyProperties(shoppingEntity, this);

    return this;
  }

}
