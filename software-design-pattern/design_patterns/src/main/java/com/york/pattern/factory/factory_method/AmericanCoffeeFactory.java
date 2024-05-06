package com.york.pattern.factory.factory_method;

public class AmericanCoffeeFactory implements CoffeeFactory {

    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
