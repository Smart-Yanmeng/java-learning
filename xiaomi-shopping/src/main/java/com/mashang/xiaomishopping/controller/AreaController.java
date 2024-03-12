package com.mashang.xiaomishopping.controller;

import com.mashang.xiaomishopping.service.AreaService;
import com.mashang.xiaomishopping.view.area.AreaListView;
import com.mashang.xiaomishopping.view.common.ResultView2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v2/area")
@Api(tags = "区域")
public class AreaController {

  @Autowired
  private AreaService areaService;

  @ApiOperation("查询区域")
  @GetMapping("{pid}")
  public ResultView2<List<AreaListView>> list(@Valid @PathVariable Integer pid) {

    List<AreaListView> areaListViewList = areaService.queryArea(pid);

    return ResultView2.success(areaListViewList);
  }

}
