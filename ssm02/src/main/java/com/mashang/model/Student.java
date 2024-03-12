package com.mashang.model;

public class Student {

    public String name;

    private Integer age;

    protected Integer sex;

    public Student() {
        System.out.println("默认构造器");
    }

    public Student(String name, Integer age, Integer sex) {
        System.out.println("有参构造器");
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void eat() {
        System.out.println("eat");
    }

    private void playGame(String gameName) {
        System.out.println("playGame = " + gameName);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
