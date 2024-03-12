package com.mashang.xiaomishopping.controller;

import com.mashang.xiaomishopping.service.ShoppingCartService;
import com.mashang.xiaomishopping.view.shoppingcart.ShoppingCartView;
import com.mashang.xiaomishopping.view.common.ResultView2;
import com.mashang.xiaomishopping.vo.shoppingcartproduct.ShoppingCartAddProductVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v2/shoppingCart")
@Api(tags = "购物车")
public class ShoppingCartController {

  @Autowired
  ShoppingCartService shoppingCartService;

  @ApiOperation("查询购物车集合")
  @GetMapping
  public ResultView2<List<ShoppingCartView>> queryShoppingCart(@RequestHeader("userId") String userId) {

    List<ShoppingCartView> shoppingCartViewList = shoppingCartService.shoppingCartList(Long.valueOf(userId));

    return ResultView2.success(shoppingCartViewList);
  }

  @ApiOperation("添加购物车商品")
  @PostMapping
  public ResultView2<Object> addShoppingCartProduct(@RequestBody ShoppingCartAddProductVo vo, @RequestHeader("userId") Long userId) {

    shoppingCartService.addShoppingCart(vo.getProductId(), userId);

    return new ResultView2<>();
  }

  @ApiOperation("查询购物车商品数量")
  @GetMapping("/product/count")
  public ResultView2<Integer> queryShoppingCartProductNum() {

    return ResultView2.success(shoppingCartService.shoppingCartProductNum());
  }

  @ApiOperation("修改购物车商品数量")
  @PutMapping("/product/num")
  public ResultView2<Object> updateShoppingCartProductNum(Integer num, Long shoppingCartId) {

    shoppingCartService.updateShoppingCartProductNum(num, shoppingCartId);

    return new ResultView2<>();
  }

  @ApiOperation("删除购物车商品")
  @DeleteMapping("{shoppingCartId}")
  public ResultView2<Object> deleteShoppingCartProduct(@PathVariable Long shoppingCartId) {

    shoppingCartService.deleteShoppingCart(shoppingCartId);

    return new ResultView2<>();
  }

}
