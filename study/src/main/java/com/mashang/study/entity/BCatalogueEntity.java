package com.mashang.study.entity;

import lombok.Data;

@Data
public class BCatalogueEntity {

  private Long catalogueId;

  private Long chapterId;

  private String catalogueName;

  private String createTime;

  private String createBy;

  private Integer videoLength;

  private Integer videoPlaybackTimes;

  private Integer rank;
}
