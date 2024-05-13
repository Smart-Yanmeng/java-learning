package com.york.pattern.visitor.double_dispatch;

public class Execute {

    public void execute(Animal a) {
        System.out.println("Animal");
    }

    public void execute(Dog d) {
        System.out.println("Dog");
    }

    public void execute(Cat c) {
        System.out.println("Cat");
    }
}
