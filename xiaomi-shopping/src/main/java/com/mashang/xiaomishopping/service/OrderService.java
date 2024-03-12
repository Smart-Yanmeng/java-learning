package com.mashang.xiaomishopping.service;

import cn.hutool.core.date.DateUtil;
import com.mashang.xiaomishopping.dao.IOrderDao;
import com.mashang.xiaomishopping.entity.BAddressEntity;
import com.mashang.xiaomishopping.entity.BOrderEntity;
import com.mashang.xiaomishopping.entity.BOrderProductEntity;
import com.mashang.xiaomishopping.view.order.OrderProductListView;
import com.mashang.xiaomishopping.view.order.OrderQueryListView;
import com.mashang.xiaomishopping.vo.order.OrderProductVo;
import com.mashang.xiaomishopping.vo.order.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

  @Autowired
  private IOrderDao orderDao;

  public List<OrderQueryListView<OrderProductListView>> orderList(Long userId) {

    List<BOrderEntity> orderEntities = orderDao.selectOrderListByCondition(userId);
    List<OrderQueryListView<OrderProductListView>> orderQueryListViewList = new ArrayList<>();

    for (BOrderEntity order : orderEntities) {
      Long orderId = order.getOrderId();

      List<OrderProductListView> productListViewList = new ArrayList<>();
      List<BOrderProductEntity> orderProductEntities = orderDao.selectOrderProductListByCondition(userId, orderId);

      for (BOrderProductEntity orderProduct : orderProductEntities) {
        productListViewList.add(new OrderProductListView().transfer(orderProduct));
      }

      OrderQueryListView<OrderProductListView> orderQueryListView = new OrderQueryListView<OrderProductListView>().transfer(order);
      orderQueryListView.setProducts(productListViewList);
      orderQueryListViewList.add(orderQueryListView);
    }

    return orderQueryListViewList;
  }

  @Transactional(rollbackFor = Exception.class)
  public void createOrder(Long addressId, List<String> shoppingCartIds) {

    BAddressEntity addressEntity = orderDao.queryOrderAddressByCondition(addressId);
    OrderVo orderVo = new OrderVo().transfer(addressEntity);
    orderVo.setOrderId(orderDao.countOrder() + 1);
    orderVo.setOrderNum(UUID.randomUUID().toString());
    orderVo.setOrderTime(DateUtil.now());

    orderDao.addOrder(orderVo);

    for (String shoppingCartId : shoppingCartIds) {
      OrderProductVo orderProductVo = new OrderProductVo().transfer(orderDao.queryShoppingCartByCondition(Long.valueOf(shoppingCartId)));
      orderProductVo.setOrderId(orderDao.countOrder());

      orderDao.addOrderProduct(orderProductVo);
      orderDao.deleteShoppingCartByCondition(Long.valueOf(shoppingCartId));

    }
  }

}
