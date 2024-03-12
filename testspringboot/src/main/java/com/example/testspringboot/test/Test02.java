package com.example.testspringboot.test;

public class Test02 {

  public static void main(String[] args) {

    HasReturnHasParam hasReturnHasParam = (int i, int j) -> i + j;

    HasReturnNoParam hasReturnNoParam = () -> 1;

    NoReturnHasParam noReturnHasParam = (int i, int j) -> System.out.println(i + j);

    NoReturnNoParam noReturnNoParam = () -> {
      System.out.println("我有两条语句");
      System.out.println("我无法消除大括号");
    };
  }


}
