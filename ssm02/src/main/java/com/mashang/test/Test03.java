package com.mashang.test;

import com.mashang.model.Student;

import java.lang.reflect.Constructor;

public class Test03 {

    public static void main(String[] args) throws Exception {
        Class stuClass = Class.forName("com.mashang.model.Student");

        // 获取默认构造器
        Constructor stuConstructor = stuClass.getConstructor();
        Student stu1 = (Student) stuConstructor.newInstance();

        System.out.println(stu1);

        // 获取有参构造器
        Constructor stuArgConstructor = stuClass.getConstructor(String.class, Integer.class, Integer.class);
        Student stu2 = (Student) stuArgConstructor.newInstance("York", 18, 1);

        System.out.println(stu2);

    }
}
