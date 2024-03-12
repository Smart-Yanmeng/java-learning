package com.mashang.xiaomishopping.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BPictureEntity {

  @ApiModelProperty("图片介绍")
  private String intro;

  @ApiModelProperty("商品图片 ID")
  private Long pictureId;

  @ApiModelProperty("商品 ID")
  private Long productId;

  @ApiModelProperty("商品图片")
  private String productPicture;

  @ApiModelProperty("创建时间")
  private String createTime;

  @ApiModelProperty("创建人")
  private String createBy;

  @ApiModelProperty("排序")
  private Integer sort;

}
