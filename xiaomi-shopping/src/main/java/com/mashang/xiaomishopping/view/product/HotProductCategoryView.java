package com.mashang.xiaomishopping.view.product;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.xiaomishopping.entity.BHotProductCategoryEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class HotProductCategoryView<T> {

  @ApiModelProperty("分类 ID")
  private Integer categoryId;

  @ApiModelProperty("分类名称")
  private String categoryName;

  @ApiModelProperty("分类封面1")
  private String categoryPicture1;

  @ApiModelProperty("商品封面2")
  private String categoryPicture2;

  @ApiModelProperty("商品列表")
  private List<T> products;

  public HotProductCategoryView<T> transfer(BHotProductCategoryEntity hotProductCategory) {
    BeanUtil.copyProperties(hotProductCategory, this);

    return this;
  }

}
