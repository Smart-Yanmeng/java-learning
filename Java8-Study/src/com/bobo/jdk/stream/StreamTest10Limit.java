package com.bobo.jdk.stream;

import java.util.stream.Stream;

public class StreamTest10Limit {
    public static void main(String[] args) {
        Stream.of("a1", "a2", "a3", "aa", "bb", "cc")
                .limit(5)
                .forEach(System.out::println);
    }
}
