package com.york.pattern.builder.demo02;

public class Client {

    public static void main(String[] args) {

        Phone phone = new Phone.Builder()
                .cpu("Snapdragon 888")
                .screen("6.7 inch")
                .memory("8GB")
                .mainBoard("Qualcomm")
                .build();

        System.out.println(phone);
    }
}
