package com.mashang.xiaomishopping.view.order;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.xiaomishopping.entity.BOrderProductEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderProductListView {

  @ApiModelProperty("数量")
  private Integer num;

  @ApiModelProperty("订单详情 ID")
  private Integer orderDtlId;

  @ApiModelProperty("商品 ID")
  private Integer productId;

  @ApiModelProperty("商品名称")
  private String productName;

  @ApiModelProperty("商品封面")
  private String productPicture;

  @ApiModelProperty("商品售价")
  private Double productSellingPrice;

  public OrderProductListView transfer(BOrderProductEntity orderProduct) {
    BeanUtil.copyProperties(orderProduct, this);

    return this;
  }

}
