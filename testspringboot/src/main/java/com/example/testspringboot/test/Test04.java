package com.example.testspringboot.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test04 {

  public static void main(String[] args) {
    List<String> strList = Arrays.asList("Hello", "world", "good", "111", "222", "333", "444", "555");

//    for (String str : strList) {
//      System.out.println(str);
//    }

//    Consumer consumer = i -> System.out.println(i);
//    strList.stream().forEach(consumer);

    // 链式写法
    strList.stream().forEach(i -> System.out.println(i));

    System.out.println("--------------------------------");

    List<String> newList1 = strList.stream().map(s -> {
      return s + 1;
    }).collect(Collectors.toList());
    newList1.stream().forEach(System.out::println);

    System.out.println("--------------------------------");

    List<String> newList2 = strList.stream().filter(s -> s.contains("l")).collect(Collectors.toList());
    newList2.forEach(s -> System.out.println(s));

    System.out.println("--------------------------------");

    // 并行
    strList.parallelStream().forEach(s -> System.out.println(s));

    // 任意一项匹配
    boolean sign1 = strList.stream().anyMatch(a -> a.contains("l"));
    System.out.println("sign1 = " + sign1);

    // 每一项都要匹配
    boolean sign2 = strList.stream().allMatch(a -> strList.contains("l"));
    System.out.println("sign2 = " + sign2);

  }
}
