package com.york.pattern.decorator;

public class Client {

    public static void main(String[] args) {

        FastFood friedRice = new FriedRice();
        System.out.println(friedRice.getDesc() + " 价钱：" + friedRice.cost() + "元");

        friedRice = new Egg(friedRice);
        System.out.println(friedRice.getDesc() + " 价钱：" + friedRice.cost() + "元");

        friedRice = new Bacon(friedRice);
        System.out.println(friedRice.getDesc() + " 价钱：" + friedRice.cost() + "元");
    }
}
