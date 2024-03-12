package com.example.testspringboot.test;

import java.util.Comparator;

public class Test01 {

  public static void main(String[] args) {
    int i = 10, j = 20;
    // 第一种实现 compare 的方式 ( 定义一个对象实现 Comparator 接口 )
    MyComparator mycomparator = new MyComparator();
    int compare = mycomparator.compare(i, j);
    System.out.println(compare);

    // 第二种匿名内部类
    Comparator comparator = new Comparator() {
      @Override
      public int compare(Object o1, Object o2) {
        return (int) o1 - (int) o2;
      }
    };
    System.out.println(comparator.compare(i, j));

    // 第三种 lambda 表达式 ( 只能有一个抽象方法 )
    Comparator comparator1 = (Object o1, Object o2) -> {
      return (int) o1 - (int) o2;
    };
    System.out.println(comparator1.compare(i, j));

    MyComparator2 myComparator2 = (int k, int m) -> {
      System.out.println(i + j);
    };

  }
}

class MyComparator implements Comparator {

  @Override
  public int compare(Object o1, Object o2) {
    return (int) o1 - (int) o2;
  }
}

// 函数式接口
@FunctionalInterface
interface MyComparator2 {
  public void getData(int i, int j);
}