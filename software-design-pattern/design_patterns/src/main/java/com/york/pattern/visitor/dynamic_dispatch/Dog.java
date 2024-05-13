package com.york.pattern.visitor.dynamic_dispatch;

public class Dog extends Animal {

    @Override
    void execute() {
        System.out.println("Dog");
    }
}
