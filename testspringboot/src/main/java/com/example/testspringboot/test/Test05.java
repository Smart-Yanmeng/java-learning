package com.example.testspringboot.test;

public class Test05 {
  public static void main(String[] args) {
    Teacher teacher1 = new Teacher();

    teacher1.setName("York");
    teacher1.setAge(18);

    // 链式写法
    Teacher teacher2 = new Teacher().setName("Zhang San").setAge(18);


  }

}
