package com.mashang.xiaomishopping.controller;

import com.mashang.xiaomishopping.service.HotProductCategoryService;
import com.mashang.xiaomishopping.service.ProductInfoService;
import com.mashang.xiaomishopping.service.ProductService;
import com.mashang.xiaomishopping.view.common.ResultView1;
import com.mashang.xiaomishopping.view.common.ResultView2;
import com.mashang.xiaomishopping.view.product.*;
import com.mashang.xiaomishopping.vo.product.ProductQueryListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/product")
@Api(tags = "商品")
public class ProductController {

  @Autowired
  private ProductService productService;

  @ApiOperation("查询商品所有数据的集合")
  @GetMapping
  public ResultView1<List<ProductListView>> queryProductList(Integer pageNum, Integer pageSize, Integer categoryId, Integer productId, String productName) {

    ProductQueryListVo vo = new ProductQueryListVo(pageNum, pageSize, categoryId, productId, productName);
    List<ProductListView> productListViewList = productService.productList(vo);
    int total = productListViewList.size();

    return ResultView1.success(productListViewList, total);
  }

  @Autowired
  private HotProductCategoryService hotProductCategoryService;

  @ApiOperation("查询热门商品所有数据的集合")
  @GetMapping("/hot")
  public ResultView1<List<HotProductCategoryView<HotProductListView>>> queryHotProductList() {

    List<HotProductCategoryView<HotProductListView>> hotProductCategoryViewList = hotProductCategoryService.hotProductCategoryList();
    int total = hotProductCategoryViewList.size();

    return ResultView1.success(hotProductCategoryViewList, total);
  }

  @Autowired
  private ProductInfoService productInfoService;

  @ApiOperation("查询商品详情")
  @GetMapping("{productId}")
  public ResultView2<ProductInfoView<PictureListView>> queryProductInfo(@RequestHeader("userId") Long userId, @PathVariable Long productId) {

    ProductInfoView<PictureListView> productInfoView = productInfoService.productInfo(userId, productId);

    return ResultView2.success(productInfoView);
  }

}
