package com.mashang.xiaomishopping.dao;

import com.mashang.xiaomishopping.entity.BProductEntity;
import com.mashang.xiaomishopping.entity.BShoppingCartEntity;
import com.mashang.xiaomishopping.vo.shoppingcartproduct.ShoppingCartProductVo;

import java.util.List;

public interface IShoppingCartDao {

  // 查询购物车列表
  List<BShoppingCartEntity> selectShoppingCartListByCondition(Long userId);

  // 添加购物车商品
  void addShoppingCartProduct(ShoppingCartProductVo vo);

  // 查询购物车商品数量
  Integer countShoppingCartProductNum();

  // 修改购物车商品数量
  void updateShoppingCartProductNum(Integer num, Long shoppingCartId);

  // 删除购物车商品
  void deleteShoppingCartProduct(Long shoppingCartId);

  // 查询商品信息
  BProductEntity queryProductByCondition(Long productId);

}
