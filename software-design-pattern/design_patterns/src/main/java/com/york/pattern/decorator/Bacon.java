package com.york.pattern.decorator;

public class Bacon extends Garnish {

    public Bacon(FastFood fastFood) {
        super(2, "培根", fastFood);
    }

    @Override
    public float cost() {
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
