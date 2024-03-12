package com.bobo.jdk.fun;

import java.util.function.Predicate;

public class PredicateDefaultTest {
    public static void main(String[] args) {
        test(msg1 -> {
            return msg1.contains("H");
        }, msg2 -> {
            return msg2.contains("W");
        });
    }

    private static void test(Predicate<String> predicate1, Predicate<String> predicate2) {
//        boolean b1 = predicate1.test(msg);
//        boolean b2 = predicate1.test("Hello");

        // b1包含H b2包含W
        // b1包含H 同时 b2包含W
        boolean bb1 = predicate1.and(predicate2).test("Hello");

        // b1包含H 或者 b2包含W
        boolean bb2 = predicate1.or(predicate2).test("Hello");

        // p1不包含H
        boolean bb3 = predicate1.negate().test("Hello");

        System.out.println(bb1); // FALSE
        System.out.println(bb2); // TRUE
        System.out.println(bb3); // FALSE
    }
}
