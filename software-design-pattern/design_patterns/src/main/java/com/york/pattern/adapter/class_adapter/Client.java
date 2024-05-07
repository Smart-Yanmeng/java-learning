package com.york.pattern.adapter.class_adapter;

public class Client {

    public static void main(String[] args) {

        Computer computer = new Computer();
        String s1 = computer.readSD(new SDCardImpl());

        System.out.println(s1);

        String s2 = computer.readSD(new SDAdapterTF());

        System.out.println(s2);
    }
}
