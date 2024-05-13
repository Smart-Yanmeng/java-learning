package com.york.pattern.iterator.jdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<Student>();

        Iterator<Student> it = new Iterator<Student>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public Student next() {
                return list.get(index++);
            }
        };

        list.add(new Student("小明", "001"));
        list.add(new Student("小红", "002"));
        list.add(new Student("小刚", "003"));

        while (it.hasNext()) {
            Student student = it.next();
            System.out.println("学生姓名：" + student.getName() + "，学号：" + student.getNumber());
        }
    }
}
