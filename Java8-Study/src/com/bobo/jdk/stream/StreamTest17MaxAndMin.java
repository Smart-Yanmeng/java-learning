package com.bobo.jdk.stream;

import java.util.stream.Stream;

public class StreamTest17MaxAndMin {
    public static void main(String[] args) {
        Integer max = Stream
                .of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .max(Integer::compare).get();
        System.out.println(max);

        Integer min = Stream
                .of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .min(Integer::compare).get();
        System.out.println(min);
    }
}