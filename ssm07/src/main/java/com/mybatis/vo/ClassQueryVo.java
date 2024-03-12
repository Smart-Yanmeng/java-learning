package com.mybatis.vo;

import java.util.List;

public class ClassQueryVo {

  private String className;

  private List<String> ids;

  public String getName() {
    return className;
  }

  public void setName(String className) {
    this.className = className;
  }

  public List<String> getIds() {
    return ids;
  }

  public void setIds(List<String> ids) {
    this.ids = ids;
  }
}
