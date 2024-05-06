package com.york.pattern.factory.simple_factory;

public class SimpleCoffeeFactory {

    public static Coffee createCoffee(String type) {
        Coffee coffee = null;

        if ("American".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("Latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("Unsupported coffee type [" + type + "]");
        }

        return coffee;
    }
}
