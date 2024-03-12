package com.mashang.xiaomishopping.controller;

import com.mashang.xiaomishopping.service.CollectService;
import com.mashang.xiaomishopping.view.collect.CollectView;
import com.mashang.xiaomishopping.view.common.ResultView2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v2/collect")
@Api(tags = "收藏")
public class CollectController {

  @Autowired
  private CollectService collectService;

  @ApiOperation("查询收藏")
  @GetMapping
  public ResultView2<Object> list(@RequestHeader("userId") String userId) {

    List<CollectView> collectViewList = collectService.collectList(Long.valueOf(userId));

    return ResultView2.success(collectViewList);
  }

  @ApiOperation("收藏/取消收藏")
  @PostMapping("{productId}")
  public ResultView2<Object> createCollect(@RequestHeader("userId") Long userId, @Valid @PathVariable Long productId) {

    collectService.createAndDeleteCollect(userId, productId);

    return new ResultView2<>();
  }

}
