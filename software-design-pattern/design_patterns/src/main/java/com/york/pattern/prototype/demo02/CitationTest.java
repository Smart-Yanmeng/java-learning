package com.york.pattern.prototype.demo02;

public class CitationTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        Citation c1 = new Citation();
        Citation c2 = c1.clone();

        c1.setName("张三");
        c2.setName("李四");

        System.out.println(c1.getName());
        System.out.println(c2.getName());
    }
}
