package com.york.pattern.visitor;

public class Someone implements Person {

    @Override
    public void feed(Cat cat) {
        System.out.println("Someone feeds cat");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("Someone feeds dog");
    }
}
