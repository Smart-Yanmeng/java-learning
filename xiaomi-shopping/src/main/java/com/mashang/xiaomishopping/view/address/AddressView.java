package com.mashang.xiaomishopping.view.address;

import cn.hutool.core.bean.BeanUtil;
import com.mashang.xiaomishopping.entity.BAddressEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddressView {

  @ApiModelProperty("地址 ID")
  private Long addressId;

  @ApiModelProperty("用户 ID")
  private Long userId;

  @ApiModelProperty("详细地址")
  private String addressDtl;

  @ApiModelProperty("标签")
  private String addressTags;

  @ApiModelProperty("区域信息")
  private String area;

  @ApiModelProperty("收货人姓名")
  private String name;

  @ApiModelProperty("收货人电话号码")
  private String phone;

  public AddressView transfer(BAddressEntity address) {
    BeanUtil.copyProperties(address, this);

    return this;
  }

}
