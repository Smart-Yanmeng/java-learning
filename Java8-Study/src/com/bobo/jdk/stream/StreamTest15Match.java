package com.bobo.jdk.stream;

import java.util.stream.Stream;

public class StreamTest15Match {
    public static void main(String[] args) {
        boolean b = Stream.of("1", "4", "-1", "1", "9", "6")
                .map(Integer::parseInt)
//                .allMatch(s -> s > 0);
//                .anyMatch(s -> s > 0);
                .noneMatch(s -> s > 0);
        System.out.println(b);
    }
}