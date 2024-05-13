package com.york.pattern.visitor;

public class Owner implements Person {

    @Override
    public void feed(Cat cat) {
        System.out.println("Owner feeds cat");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("Owner feeds dog");
    }
}
