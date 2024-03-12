package com.mashang.xiaomishopping.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BHotProductCategoryEntity {

  @ApiModelProperty("商品主键 ID")
  private Long categoryId;

  @ApiModelProperty("商品名称")
  private String categoryName;

  @ApiModelProperty("分类封面1")
  private String categoryPicture1;

  @ApiModelProperty("分类封面2")
  private String categoryPicture2;

  @ApiModelProperty("创建时间")
  private String createTime;

  @ApiModelProperty("创建人")
  private String createBy;

  @ApiModelProperty("排序")
  private Integer sort;

}
