package com.mashang.xiaomishopping.view.collect;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.xiaomishopping.entity.BCollectEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CollectView {

  @ApiModelProperty("收藏 ID")
  private Long collectId;

  @ApiModelProperty("商品 ID")
  private Long productId;

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

  public CollectView transfer(BCollectEntity collect) {
    BeanUtil.copyProperties(collect, this);

    return this;
  }

}
