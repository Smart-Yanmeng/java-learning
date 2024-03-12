package com.mashang.xiaomishopping.service;

import com.mashang.xiaomishopping.dao.IShoppingCartDao;
import com.mashang.xiaomishopping.entity.BShoppingCartEntity;
import com.mashang.xiaomishopping.view.shoppingcart.ShoppingCartView;
import com.mashang.xiaomishopping.vo.shoppingcartproduct.ShoppingCartProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartService {

  @Autowired
  private IShoppingCartDao shoppingCartDao;

  public List<ShoppingCartView> shoppingCartList(Long userId) {

    List<BShoppingCartEntity> shoppingCartEntities = shoppingCartDao.selectShoppingCartListByCondition(userId);

    return shoppingCartEntities.stream().map(s -> new ShoppingCartView().transfer(s)).collect(Collectors.toList());
  }

  @Transactional(rollbackFor = Exception.class)
  public void addShoppingCart(Long productId, Long userId) {

    ShoppingCartProductVo shoppingCartProductVo = new ShoppingCartProductVo().transfer(shoppingCartDao.queryProductByCondition(productId));
    shoppingCartProductVo.setUserId(userId);
    if (shoppingCartProductVo.getNum() == null) shoppingCartProductVo.setNum(1);

    shoppingCartDao.addShoppingCartProduct(shoppingCartProductVo);
  }

  public Integer shoppingCartProductNum() {

    return shoppingCartDao.countShoppingCartProductNum();
  }

  @Transactional(rollbackFor = Exception.class)
  public void updateShoppingCartProductNum(Integer num, Long shoppingCartId) {

    shoppingCartDao.updateShoppingCartProductNum(num, shoppingCartId);
  }

  @Transactional(rollbackFor = Exception.class)
  public void deleteShoppingCart(Long shoppingCartId) {

    shoppingCartDao.deleteShoppingCartProduct(shoppingCartId);
  }

}
