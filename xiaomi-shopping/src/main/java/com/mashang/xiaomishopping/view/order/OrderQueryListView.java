package com.mashang.xiaomishopping.view.order;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.xiaomishopping.entity.BOrderEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrderQueryListView<T> {

  @ApiModelProperty("用户 ID")
  private Long userId;

  @ApiModelProperty("详细地址")
  private String addressDtl;

  @ApiModelProperty("标签")
  private String addressTags;

  @ApiModelProperty("收货人姓名")
  private String addressee;

  @ApiModelProperty("区域信息")
  private String addresseeArea;

  @ApiModelProperty("收货人电话号码")
  private String addresseePhone;

  @ApiModelProperty("订单 ID")
  private Long orderId;

  @ApiModelProperty("订单号")
  private String orderNum;

  @ApiModelProperty("订单时间")
  private String orderTime;

  @ApiModelProperty("订单商品")
  private List<T> products;

  public OrderQueryListView<T> transfer(BOrderEntity order) {
    BeanUtil.copyProperties(order, this);

    return this;
  }

}
