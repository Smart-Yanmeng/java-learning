package com.york.easyboot.reflection;

public class TestReflection {

    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(animal.getClass().getName());
    }
}
