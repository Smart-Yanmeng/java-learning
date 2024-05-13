package com.york.pattern.visitor.dynamic_dispatch;

public class Client {

    public static void main(String[] args) {

        Animal a = new Animal();
        Animal d = new Dog();
        Animal c = new Cat();

        a.execute();
        d.execute();
        c.execute();
    }
}
