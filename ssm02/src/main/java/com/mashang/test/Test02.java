package com.mashang.test;

import com.mashang.model.Student;

import java.lang.reflect.Field;

public class Test02 {

    public static void main(String[] args) throws Exception {
        Class stuClass = Class.forName("com.mashang.model.Student");

        // 获取公共属性
        Field[] fields = stuClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("--------------------------------------------------------------");

        // 获取全部属性
        Field[] fieldsAll = stuClass.getDeclaredFields();
        for (Field field : fieldsAll) {
            System.out.println(field);

            if (field.getName().equals("name")) {
                // 赋值
            }
        }

        // 获取到属性对象后, 可以给这个类的属性直接赋值
        Student stu = new Student();

        Field nameField = stuClass.getField("name");
        // 给 stu 这个对象中属于 public 的 name 属性赋值
        nameField.set(stu, "York");

        Field ageField = stuClass.getDeclaredField("age");
        // 给 stu 这个对象中不属于 public 的 age 属性赋值
        // 开启私有属性的权限
        ageField.setAccessible(true);
        ageField.set(stu, 18);

        System.out.println(stu);
    }
}
