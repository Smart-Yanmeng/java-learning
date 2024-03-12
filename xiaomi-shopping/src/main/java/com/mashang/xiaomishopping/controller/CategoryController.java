package com.mashang.xiaomishopping.controller;

import com.mashang.xiaomishopping.service.CategoryService;
import com.mashang.xiaomishopping.view.category.CategoryView;
import com.mashang.xiaomishopping.view.common.ResultView2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v2/category")
@Api(tags = "商品分类")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @ApiOperation("查询商品分类所有数据的集合")
  @GetMapping
  public ResultView2<List<CategoryView>> list() {

    List<CategoryView> categoryViewList = categoryService.categoryList();

    return ResultView2.success(categoryViewList);
  }
}
