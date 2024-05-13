package com.york.pattern.visitor;

public class Dog implements Animal {

    @Override
    public void accept(Person person) {
        person.feed(this);

        System.out.println("Dog has been fed");
    }
}
