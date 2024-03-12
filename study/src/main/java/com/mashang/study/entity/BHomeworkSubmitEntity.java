package com.mashang.study.entity;

import lombok.Data;

@Data
public class BHomeworkSubmitEntity {

  private Long homeworkId;

  private Long userId;

  private String submitTime;

  private Integer isSubmit;

}
