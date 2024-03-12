package com.bobo.jdk.fun;

import java.util.function.Function;

public class FunctionAndThenTest {
    public static void main(String[] args) {
        test(msg1 -> {
            return Integer.parseInt(msg1);
        }, msg2 -> {
            return msg2 * 10;
        });
    }

    public static void test(Function<String, Integer> function1, Function<Integer, Integer> function2) {
//        Integer i1 = function1.apply("666");
//        Integer i2 = function2.apply(i1);
        Integer i2 = function1.andThen(function2).apply("666");

        System.out.println("i2 = " + i2);
    }
}
