package com.quanshi.chapter2_2;

/**
 * 2.2.1 变量的定义和赋值
 * 2.2.2 变量的书记类型
 * 2.2.3 变量的类型转换
 */

public class Variable {
  public static void main(String[] args) {
    // 定义和赋值
    int x = 0, y;
    y = x + 3;

    // 变量的数据类型
    long num1 = 2200000000L; // 所赋值的内容超出了 int 类型的取值范围时，需在结尾加上字母 L
    long num2 = 198L;
    long num3 = 198;

    float f = 123.4f; // 为一个 float 类型的变量赋值，后面必须加上字母 f
    double d1 = 100.1d;
    double d2 = 100.1;

    char c1 = 'a';
    char c2 = 97;

    // 变量的类型转换
    /* 自动类型转换 */
    byte b1 = 3;
    int b2 = b1;

    /* 强制类型转换 */
    int e1 = 4;
//    byte e2 = e1;
    byte e2 = (byte) e1;
  }

}
