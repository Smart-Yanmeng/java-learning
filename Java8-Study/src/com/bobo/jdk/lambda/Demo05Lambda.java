package com.bobo.jdk.lambda;

import com.bobo.jdk.lambda.domain.Person;
import com.bobo.jdk.lambda.service.OrderService;
import com.bobo.jdk.lambda.service.StudentService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo05Lambda {
    public static void main(String[] args) {
        goStudent((String name, Integer age) -> {
            return name + age + " 666...";
        });
        // 省略写法
        goStudent((name, age) -> name + age + " 666...");

        System.out.println("----------------------------");
        goOrder((String name) -> {
            System.out.println("--->" + name);
            return 666;
        });
        // 省略写法
        goOrder(name -> {
            System.out.println("--->" + name);
            return 666;
        });
    }

    public static void goStudent(StudentService studentService) {
        studentService.show("张三", 22);
    }

    public static void goOrder(OrderService orderService) {
        orderService.show("李四");
    }
}
