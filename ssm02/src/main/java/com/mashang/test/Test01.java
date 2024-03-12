package com.mashang.test;

import com.mashang.model.Student;

public class Test01 {

    public static void main(String[] args) throws ClassNotFoundException {

        Student stu = new Student();

        // 获取 Student 类的 Class
        Class stuCla01 = stu.getClass();
        Class stuCla02 = Student.class;
        Class stuCla03 = Class.forName("com.mashang.model.Student");

        System.out.println(stuCla01);
        System.out.println(stuCla02);
        System.out.println(stuCla03);

    }

}
