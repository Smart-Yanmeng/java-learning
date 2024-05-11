package com.york.pattern.flyweight;

public class Client {

    public static void main(String[] args) {

        AbstractBox box1 = BoxFactory.getInstance().getShape("I");
        box1.display("red");

        AbstractBox box2 = BoxFactory.getInstance().getShape("L");
        box2.display("green");

        AbstractBox box3 = BoxFactory.getInstance().getShape("O");
        box3.display("blue");

        AbstractBox box4 = BoxFactory.getInstance().getShape("O");
        box4.display("yellow");

        System.out.println(box3 == box4);
    }
}
