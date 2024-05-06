package com.york.pattern.builder.demo01;

public abstract class Builder {

    protected Bike mBike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public abstract Bike createBike();

    public Bike construct() {
        this.buildFrame();
        this.buildSeat();
        return this.createBike();
    }
}
