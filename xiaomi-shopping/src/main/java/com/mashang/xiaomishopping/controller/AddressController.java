package com.mashang.xiaomishopping.controller;

import com.mashang.xiaomishopping.service.AddressService;
import com.mashang.xiaomishopping.view.address.AddressView;
import com.mashang.xiaomishopping.view.common.ResultView2;
import com.mashang.xiaomishopping.vo.address.AddressVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/address")
@Api(tags = "收货地址")
public class AddressController {

  @Autowired
  private AddressService addressService;

  @ApiOperation("添加收货地址")
  @PostMapping
  public ResultView2<Object> addAddress(@RequestHeader("userId") Long userId, @RequestBody AddressVo vo) {

    addressService.addAddress(vo, userId);

    return new ResultView2<>();
  }

  @ApiOperation("修改收货地址")
  @PutMapping
  public ResultView2<Object> updateAddress(@RequestBody AddressVo vo) {

    addressService.updateAddress(vo);

    return new ResultView2<>();
  }

  @ApiOperation("查询当前用户地址信息")
  @GetMapping("/list")
  public ResultView2<Object> queryAddress(@RequestHeader("userId") Long userId) {

    List<AddressView> addressViewList = addressService.queryAddress(userId);

    return ResultView2.success(addressViewList);
  }

  @ApiOperation("删除收货地址")
  @DeleteMapping("{addressId}")
  public ResultView2<Object> deleteAddress(@PathVariable Long addressId) {

    addressService.deleteAddress(addressId);

    return new ResultView2<>();
  }

}
