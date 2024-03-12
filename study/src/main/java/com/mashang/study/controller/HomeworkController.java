package com.mashang.study.controller;

import com.mashang.study.service.HomeworkService;
import com.mashang.study.view.ResultView;
import com.mashang.study.view.homework.HomeworkSubmitView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student_manager/homework")
public class HomeworkController {

  @Autowired
  private HomeworkService homeworkService;

  // 提交
  @PostMapping("/submit")
  public HomeworkSubmitView HomeworkSubmit() {

    return null;
  }

  // 个人
  @GetMapping("{id}")
  public ResultView MyHomework() {

    return null;
  }
}
