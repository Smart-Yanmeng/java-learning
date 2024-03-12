package com.mashang.xiaomishopping.view.carousel;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.xiaomishopping.entity.BCarouselEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CarouselView {

  @ApiModelProperty("轮播图 ID")
  private Long carouselId;

  @ApiModelProperty("轮播图描述")
  private String describes;

  @ApiModelProperty("轮播图路径")
  private String url;

  public CarouselView transfer(BCarouselEntity carousel) {
    BeanUtil.copyProperties(carousel, this);

    return this;
  }

}
