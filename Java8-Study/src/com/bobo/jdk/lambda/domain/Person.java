package com.bobo.jdk.lambda.domain;

public class Person {

    private String name;

    private Integer age;

    private Integer height;

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String s, Integer integer) {
        this.name = s;
        this.age = integer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
