package com.example.testspringboot.test;

public class Teacher {

  private String name;

  private Integer age;

  public String getName() {
    return name;
  }

  public Teacher setName(String name) {
    this.name = name;

    return this;
  }

  public Integer getAge() {
    return age;
  }

  public Teacher setAge(Integer age) {
    this.age = age;

    return this;
  }
}
