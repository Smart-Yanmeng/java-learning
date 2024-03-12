package com.mashang.jdbc;

public class Student {
    private Integer id;

    private String name;

    private String sex;

    private String email;

    private Integer classes_id;

    public Student(Integer id, String name, String sex, String email, Integer class_id) {

        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.classes_id = class_id;

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", classes_id=" + classes_id +
                '}';
    }
}
