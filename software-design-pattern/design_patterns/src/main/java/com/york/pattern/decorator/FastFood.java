package com.york.pattern.decorator;

public abstract class FastFood {

    private float price;

    private String desc;

    public FastFood(float price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    FastFood() {
    }

    public float getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public abstract float cost();
}
