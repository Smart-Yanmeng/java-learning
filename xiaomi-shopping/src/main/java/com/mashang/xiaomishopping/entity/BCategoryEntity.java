package com.mashang.xiaomishopping.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BCategoryEntity {

  @ApiModelProperty("分类主键 ID")
  private Long categoryId;

  @ApiModelProperty("分类名称")
  private String categoryName;

  @ApiModelProperty("创建时间")
  private String createTime;

  @ApiModelProperty("创建人")
  private String createBy;

  @ApiModelProperty("排序")
  private Integer sort;

}
