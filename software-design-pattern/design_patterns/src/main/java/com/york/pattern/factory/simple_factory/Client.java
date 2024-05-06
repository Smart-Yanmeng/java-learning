package com.york.pattern.factory.simple_factory;

public class Client {

    public static void main(String[] args) {

        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("American");

        System.out.println(coffee.getName());
    }
}
