package com.mybatis.view;

import com.mybatis.entity.Student;

import java.util.List;

public class ClazzView {
  private String classId;

  private String classNo;

  private String createTime;

  private String name;

  private String remark;

  private Integer type;

  private List<Student> studentsList;

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

  public List<Student> getStudentsList() {
    return studentsList;
  }

  public void setStudentsList(List<Student> studentsList) {
    this.studentsList = studentsList;
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
