package com.york.pattern.visitor;

public class Cat implements Animal {

    @Override
    public void accept(Person person) {
        person.feed(this);

        System.out.println("Cat has been fed");
    }
}
