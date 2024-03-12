package com.mashang.vo;

public class    StudentQueryVo {

    private String name;

    private Integer age;

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

    @Override
    public String toString() {
        return "StudentQueryVo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
