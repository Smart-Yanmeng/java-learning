package com.bobo.jdk.funref;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionRefTest05 {

    public static void main(String[] args) {
        Function<String, Integer> function1 = s -> {
            return s.length();
        };
        System.out.println(function1.apply("Hello"));

        // 方法引用
        Function<String, Integer> function2 = String::length;
        System.out.println(function2.apply("Hello"));

        BiFunction<String, Integer, String> function3 = String::substring;
        String msg = function3.apply("Hello World", 3);
        System.out.println(msg);
    }
}
