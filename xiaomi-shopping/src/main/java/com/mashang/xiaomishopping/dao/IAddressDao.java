package com.mashang.xiaomishopping.dao;

import com.mashang.xiaomishopping.entity.BAddressEntity;
import com.mashang.xiaomishopping.vo.address.AddressVo;

import java.util.List;

public interface IAddressDao {

  // 添加收货地址
  void addAddress(AddressVo vo);

  // 修改收获地址
  void updateAddress(AddressVo vo);

  // 查询当前用户地址信息
  List<BAddressEntity> queryAddressByCondition(Long userId);

  // 删除收货地址
  void deleteAddressByCondition(Long addressId);

}
