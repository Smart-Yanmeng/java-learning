package com.mashang.xiaomishopping.vo.shoppingcartproduct;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ShoppingCartAddProductVo {

  @NotBlank
  @ApiModelProperty(value = "商品 ID", required = true)
  private Long productId;

}
