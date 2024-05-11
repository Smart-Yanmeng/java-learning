package com.york.pattern.strategy;

public class SalesMan {

    private final Strategy strategy;

    public SalesMan(Strategy strategy) {
        this.strategy = strategy;
    }

    public void show() {
        strategy.show();
    }
}
