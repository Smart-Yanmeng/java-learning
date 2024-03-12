package com.qztc;

import java.util.Objects;

// Java 16 之前
// 不可变的对象
public final class RecordTest1 {
    final String name;

    final Integer age;

    public RecordTest1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "RecordTest1{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordTest1 that = (RecordTest1) o;
        return Objects.equals(name, that.name) && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
