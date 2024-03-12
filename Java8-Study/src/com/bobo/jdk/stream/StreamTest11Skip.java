package com.bobo.jdk.stream;

import java.util.stream.Stream;

public class StreamTest11Skip {
    public static void main(String[] args) {
        Stream.of("a1", "a2", "a3", "aa", "bb", "cc")
                .skip(3)
                .forEach(System.out::println);
    }
}
