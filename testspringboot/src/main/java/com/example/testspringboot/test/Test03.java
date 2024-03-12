package com.example.testspringboot.test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class Test03 {

  public static void main(String[] args) {
    // 方法的引用
    // 静态方法的引用  类::静态方法
    Comparator comparator = (i, j) -> (int) i - (int) j;
    Comparator<Integer> comparator1 = Integer::compare;

    // 实例方法的引用  类::实例方法
    BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
    BiPredicate<String, String> biPredicate1 = String::equals;

    // 对象实例方法的引用  对象::实例方法
    User user = new User();
    Supplier supplier = user::getName;

    // 构造器的引用  对象::new
    BiFunction<String, String, User> biFunction = User::new;
    User user1 = biFunction.apply("York", "18");

  }
}

class User {
  private String name;

  private String age;

  public User() {

  }

  public User(String name, String age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }
}