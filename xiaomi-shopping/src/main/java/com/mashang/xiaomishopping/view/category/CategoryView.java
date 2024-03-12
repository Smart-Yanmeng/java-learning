package com.mashang.xiaomishopping.view.category;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.xiaomishopping.entity.BCategoryEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CategoryView {

  @ApiModelProperty("分类主键 ID")
  private Long categoryId;

  @ApiModelProperty("分类名称")
  private String categoryName;

  public CategoryView transfer(BCategoryEntity category) {
    BeanUtil.copyProperties(category, this);

    return this;
  }

}
