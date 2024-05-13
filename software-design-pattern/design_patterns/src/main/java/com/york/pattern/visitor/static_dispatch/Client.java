package com.york.pattern.visitor.static_dispatch;

public class Client {

    public static void main(String[] args) {

        Animal a = new Animal();
        Animal d = new Dog();
        Animal c = new Cat();

        Execute e = new Execute();
        e.execute(a);
        e.execute(d);
        e.execute(c);
    }
}
