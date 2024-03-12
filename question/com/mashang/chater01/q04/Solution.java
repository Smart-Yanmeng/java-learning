package com.mashang.chater01.q04;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        double s = 0;
        Scanner sc = new Scanner(System.in);
        double r1, r2;
        r1 = sc.nextDouble();
        r2 = sc.nextDouble();
        Circle c1 = new Circle(r1);
        Circle c2 = new Circle(r2);
        try {
            s = c1.area();
            System.out.println(s);
            s = c2.area();
            System.out.println(s);
        } catch (CircleException e) {
            e.print();
        }
    }
}

class CircleException extends Exception {
    double r;

    public CircleException(double r) {
        this.r = r;
    }

    public void print() {
        System.out.println("圆半径为" + r + "不合理");
    }
}

class Circle {
    private final double r;

    public Circle(double r) {
        this.r = r;
    }

    public double area() throws CircleException {
        if (r >= 0) return 3.14 * r * r;
        throw new CircleException(r);
    }
}
