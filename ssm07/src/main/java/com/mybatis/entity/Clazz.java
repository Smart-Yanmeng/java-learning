package com.mybatis.entity;

public class Clazz {
  private String classId;

  private String classNo;

  private String createTime;

  private String name;

  private String remark;

  private Integer type;

  public String getClassId() {
    return classId;
  }

  public void setClassId(String classId) {
    this.classId = classId;
  }

  public String getClassNo() {
    return classNo;
  }

  public void setClassNo(String classNo) {
    this.classNo = classNo;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Clazz{" +
            "classId='" + classId + '\'' +
            ", classNo='" + classNo + '\'' +
            ", createTime='" + createTime + '\'' +
            ", name='" + name + '\'' +
            ", remark='" + remark + '\'' +
            ", type=" + type +
            '}';
  }
}
