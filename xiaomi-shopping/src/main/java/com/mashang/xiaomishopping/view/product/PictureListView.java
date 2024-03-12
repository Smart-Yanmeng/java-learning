package com.mashang.xiaomishopping.view.product;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.xiaomishopping.entity.BPictureEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PictureListView {

  @ApiModelProperty("图片介绍")
  private String intro;

  @ApiModelProperty("商品图片 ID")
  private Long pictureId;

  @ApiModelProperty("商品 ID")
  private Long productId;

  @ApiModelProperty("商品图片")
  private String productPicture;

  public PictureListView transfer(BPictureEntity pictureEntity) {
    BeanUtil.copyProperties(pictureEntity, this);

    return this;
  }

}
