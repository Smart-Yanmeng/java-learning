package com.mashang.xiaomishopping.vo.order;

import com.mashang.xiaomishopping.entity.BShoppingCartEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("订单商品信息集合")
public class OrderProductVo {

  @ApiModelProperty("订单 ID")
  private Long orderId;

  @ApiModelProperty("商品详情 ID")
  private Long orderDtlId;

  @ApiModelProperty("商品 ID")
  private Long productId;

  @ApiModelProperty("商品数量")
  private Integer num;

  @ApiModelProperty("商品名称")
  private String productName;

  @ApiModelProperty("商品封面")
  private String productPicture;

  @ApiModelProperty("商品售价")
  private Double productSellingPrice;

  public OrderProductVo transfer(BShoppingCartEntity shoppingCart) {
    this.productId = shoppingCart.getProductId();
    this.productName = shoppingCart.getProductName();
    this.productPicture = shoppingCart.getProductPicture();
    this.productSellingPrice = shoppingCart.getProductSellingPrice();
    this.num = shoppingCart.getNum();

    return this;
  }

}
