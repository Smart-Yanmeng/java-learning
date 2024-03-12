package com.bobo.jdk.stream;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest16Find {
    public static void main(String[] args) {
        Optional<String> first = Stream.of("1", "4", "-1", "1", "9", "6").findFirst();
        System.out.println(first.get());

        Optional<String> any = Stream.of("1", "4", "-1", "1", "9", "6").findAny();
        System.out.println(any.get());
    }
}