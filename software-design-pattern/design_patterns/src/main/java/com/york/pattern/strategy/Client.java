package com.york.pattern.strategy;

public class Client {

    public static void main(String[] args) {

        SalesMan salesMan = new SalesMan(new StrategyA());
        salesMan.show();
    }
}
