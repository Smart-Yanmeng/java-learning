package com.mashang.xiaomishopping.dao;

import com.mashang.xiaomishopping.entity.BAddressEntity;
import com.mashang.xiaomishopping.entity.BOrderEntity;
import com.mashang.xiaomishopping.entity.BOrderProductEntity;
import com.mashang.xiaomishopping.entity.BShoppingCartEntity;
import com.mashang.xiaomishopping.vo.order.OrderProductVo;
import com.mashang.xiaomishopping.vo.order.OrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOrderDao {

  // 查询订单列表
  List<BOrderEntity> selectOrderListByCondition(Long userId);

  // 查询订单商品信息列表
  List<BOrderProductEntity> selectOrderProductListByCondition(@Param("userId") Long userId, @Param("orderId") Long orderId);

  // 查询购物车内商品信息
  BShoppingCartEntity queryShoppingCartByCondition(Long shoppingCartId);

  // 查询订单数量
  Long countOrder();

  // 查询地址信息
  BAddressEntity queryOrderAddressByCondition(Long addressId);

  // 生成订单框架
  void addOrder(OrderVo vo);

  // 生成订单主体
  void addOrderProduct(OrderProductVo vo);

  // 删除购物车
  void deleteShoppingCartByCondition(Long shoppingCartId);

}
