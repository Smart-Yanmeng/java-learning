package com.bobo.jdk.stream;

import java.util.stream.Stream;

public class StreamTest09Filter {
    public static void main(String[] args) {
        Stream.of("a1", "a2", "a3", "cc", "bb", "aa")
                .filter((s) -> s.contains("a"))
                .forEach(System.out::println);
    }
}
