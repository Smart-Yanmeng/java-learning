package com.mashang.xiaomishopping.view.area;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.xiaomishopping.entity.BAreaEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AreaListView {

  @ApiModelProperty("区域 ID")
  private Long id;

  @ApiModelProperty("区域名称")
  private String name;

  @ApiModelProperty("区域父 ID")
  private Long pid;

  public AreaListView transfer(BAreaEntity area) {
    BeanUtil.copyProperties(area, this);

    return this;
  }

}
