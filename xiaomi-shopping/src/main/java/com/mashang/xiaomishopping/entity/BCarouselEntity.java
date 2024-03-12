package com.mashang.xiaomishopping.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BCarouselEntity {

  @ApiModelProperty("轮播图 ID")
  private Long carouselId;

  @ApiModelProperty("轮播图描述")
  private String describes;

  @ApiModelProperty("轮播图路径")
  private String url;

  @ApiModelProperty("创建时间")
  private String createTime;

  @ApiModelProperty("创建人")
  private String createBy;

  @ApiModelProperty("排序")
  private Integer sort;

}
