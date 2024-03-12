package com.mashang.xiaomishopping.controller;

import com.mashang.xiaomishopping.service.OrderService;
import com.mashang.xiaomishopping.view.common.ResultView2;
import com.mashang.xiaomishopping.view.order.OrderProductListView;
import com.mashang.xiaomishopping.view.order.OrderQueryListView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v2/orders")
@Api(tags = "订单")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @ApiOperation("查询订单信息集合")
  @GetMapping
  public ResultView2<List<OrderQueryListView<OrderProductListView>>> getOrder(@RequestHeader("userId") String userId) {

    List<OrderQueryListView<OrderProductListView>> list = orderService.orderList(Long.valueOf(userId));

    return ResultView2.success(list);
  }

  @ApiOperation("生成订单")
  @PostMapping("/create")
  public ResultView2<Object> createOrder(Long addressId, String shoppingCartIds) {

    String[] shoppingCartIdList = shoppingCartIds.split(",");

    orderService.createOrder(addressId, Arrays.asList(shoppingCartIdList));

    return new ResultView2<>();
  }

}
