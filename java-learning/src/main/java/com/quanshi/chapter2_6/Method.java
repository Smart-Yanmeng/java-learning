package com.quanshi.chapter2_6;

/**
 * 2.6.2 方法的重载
 */

public class Method {
  public static void main(String[] args) {
    int sum1 = add(1, 2);
    int sum2 = add(1, 2, 3);
    double sum3 = add(1.2, 2.3);
  }

  public static int add(int a, int b) {

    return a + b;
  }

  public static int add(int a, int b, int c) {

    return a + b + c;
  }

  public static double add(double a, double b) {

    return a + b;
  }

}
