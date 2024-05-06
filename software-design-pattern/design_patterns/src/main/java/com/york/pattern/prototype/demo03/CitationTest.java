package com.york.pattern.prototype.demo03;

public class CitationTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        Citation c1 = new Citation();
        Student student1 = new Student();
        student1.setName("张三");
        c1.setStudent(student1);

        // 浅克隆导致两个对象的引用指向同一个对象
        Citation c2 = c1.clone();
        c1.getStudent().setName("李四");

        System.out.println(c1.getStudent().getName());
        System.out.println(c2.getStudent().getName());
    }
}
