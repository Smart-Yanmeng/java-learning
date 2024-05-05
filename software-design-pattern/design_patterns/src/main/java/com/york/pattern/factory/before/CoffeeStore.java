package com.york.pattern.factory.before;

public class CoffeeStore {

    public Coffee orderCoffee(String type) {

        Coffee coffee = null;

        if ("American".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("Latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("不支持的咖啡类型");
        }

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
