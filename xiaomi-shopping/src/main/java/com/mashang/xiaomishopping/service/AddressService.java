package com.mashang.xiaomishopping.service;

import com.mashang.xiaomishopping.dao.IAddressDao;
import com.mashang.xiaomishopping.entity.BAddressEntity;
import com.mashang.xiaomishopping.view.address.AddressView;
import com.mashang.xiaomishopping.vo.address.AddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

  @Autowired
  private IAddressDao addressDao;

  @Transactional(rollbackFor = Exception.class)
  public void addAddress(AddressVo vo, Long userId) {

    vo.setUserId(userId);

    addressDao.addAddress(vo);
  }

  @Transactional(rollbackFor = Exception.class)
  public void updateAddress(AddressVo vo) {

    addressDao.updateAddress(vo);
  }

  public List<AddressView> queryAddress(Long userId) {

    List<BAddressEntity> addressEntities = addressDao.queryAddressByCondition(userId);

    return addressEntities.stream().map(s -> new AddressView().transfer(s)).collect(Collectors.toList());
  }

  @Transactional(rollbackFor = Exception.class)
  public void deleteAddress(Long addressId) {

    addressDao.deleteAddressByCondition(addressId);
  }

}
