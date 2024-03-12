package com.mashang.study.service;

import com.mashang.study.dao.IHomeworkDao;
import com.mashang.study.entity.BHomeworkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkService {

  @Autowired
  private IHomeworkDao homeworkDao;

  // 所有人的作业情况
  public List<BHomeworkEntity> SelectHomeworkInfo() {

    return null;
  }

  // submit
  public BHomeworkEntity HomeworkSubmit() {

    return null;
  }

}
