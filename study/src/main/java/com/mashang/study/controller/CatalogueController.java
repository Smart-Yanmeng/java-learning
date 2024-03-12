package com.mashang.study.controller;

import com.mashang.study.service.CatalogueService;
import com.mashang.study.view.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student_manager/catalogue")
public class CatalogueController {

  @Autowired
  private CatalogueService catalogueService;

  // 查询视频信息
  @PostMapping("/videoInfo")
  public ResultView videoInfo() {

    return null;
  }

}
