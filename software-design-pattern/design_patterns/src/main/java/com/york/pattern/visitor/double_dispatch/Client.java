package com.york.pattern.visitor.double_dispatch;

public class Client {

    public static void main(String[] args) {

        Animal a = new Animal();
        Animal d = new Dog();
        Animal c = new Cat();

        Execute e = new Execute();
        a.accept(e);
        d.accept(e);
        c.accept(e);
    }
}
