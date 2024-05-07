package com.york.pattern.adapter.object_adapter;

public class Client {

    public static void main(String[] args) {

        Computer computer = new Computer();
        String s1 = computer.readSD(new SDCardImpl());

        System.out.println(s1);

        SDAdapterTF sdAdapterTF = new SDAdapterTF(new TFCardImpl());
        String s2 = computer.readSD(sdAdapterTF);

        System.out.println(s2);
    }
}
