package com.mashang.xiaomishopping.controller;

import com.mashang.xiaomishopping.service.CarouselService;
import com.mashang.xiaomishopping.view.carousel.CarouselView;
import com.mashang.xiaomishopping.view.common.ResultView2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v2/carousel")
@Api(tags = "轮播图")
public class CarouselController {

  @Autowired
  private CarouselService carouselService;

  @ApiOperation("轮播图查询")
  @GetMapping
  public ResultView2<List<CarouselView>> list() {

    List<CarouselView> carouselViewList = carouselService.carouselList();

    return ResultView2.success(carouselViewList);
  }
}
