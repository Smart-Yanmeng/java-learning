package com.example.springbootswagger.controller;

import com.example.springbootswagger.model.Clazz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clazz")
@Api(tags = "班级管理")
public class ClazzController {

  @PostMapping("/queryClazz")
  @ApiOperation("查询班级信息")
  public Clazz queryClazz(@Valid @RequestBody Clazz clazz) {
    System.out.println("ClazzController.queryClazz");
    return clazz;
  }

  @PostMapping("/saveClazz")
  @ApiOperation("保存班级")
  public String saveClazz(Clazz clazz) {
    System.out.println("ClazzController.saveClazz");

    return "success";
  }
}
