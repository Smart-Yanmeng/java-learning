package com.mashang.test;

import com.mashang.model.Student;

import java.lang.reflect.Method;

public class Test04 {

    public static void main(String[] args) throws Exception {
        Class stuClass = Class.forName("com.mashang.model.Student");

        Method[] stuMethods = stuClass.getMethods();
        for (Method stuMethod : stuMethods) {
            System.out.println(stuMethod);
        }

        System.out.println("-------------------------------------");

        Method[] stuAllMethods = stuClass.getDeclaredMethods();
        for (Method stuMethod : stuAllMethods) {
            System.out.println(stuMethod);
        }

        System.out.println("-------------------------------------");

        Student stu = new Student();

        // 通过反射的方式调用 public 权限的方法
        Method eatMethod = stuClass.getDeclaredMethod("eat");
        eatMethod.invoke(stu);

        // 通过反射的方式调用 private 权限的方法
        Method playGameMethod = stuClass.getDeclaredMethod("playGame", String.class);
        playGameMethod.setAccessible(true);
        playGameMethod.invoke(stu, "LOL");
    }
}
