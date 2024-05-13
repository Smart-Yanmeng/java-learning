package com.york.pattern.visitor;

public class Client {

    public static void main(String[] args) {

        Home home = new Home();
        home.addAnimal(new Cat());
        home.addAnimal(new Dog());

        Owner owner = new Owner();
        home.action(owner);

        Someone someone = new Someone();
        home.action(someone);
    }
}
