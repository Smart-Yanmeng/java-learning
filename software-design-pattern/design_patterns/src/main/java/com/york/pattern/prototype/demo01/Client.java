package com.york.pattern.prototype.demo01;

public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {

        RealizeType realizeType = new RealizeType();

        RealizeType clone = realizeType.clone();

        System.out.println("realizeType == clone ? " + (realizeType == clone));
    }
}
