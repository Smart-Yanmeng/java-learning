package com.york.pattern.builder.demo01;

public class Client {

    public static void main(String[] args) {

//        Director director = new Director(new OfoBuilder());
//        Bike bike = director.construct();
//
//        System.out.println("frame: " + bike.getFrame());
//        System.out.println("seat: " + bike.getSeat());

        Bike bike = new OfoBuilder().construct();

        System.out.println("frame: " + bike.getFrame());
        System.out.println("seat: " + bike.getSeat());
    }
}
