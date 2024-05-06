package com.york.pattern.factory.config_factory;

public class Client {

    public static void main(String[] args) {

        Coffee coffee = CoffeeFactory.createCoffee("American");
        System.out.println(coffee.getName());
    }
}
