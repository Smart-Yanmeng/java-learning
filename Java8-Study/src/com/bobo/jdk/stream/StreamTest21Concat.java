package com.bobo.jdk.stream;

import java.util.stream.Stream;

public class StreamTest21Concat {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("a", "b", "c");
        Stream<String> stream2 = Stream.of("d", "e", "f");

        // 通过 concat 方法将两个流合并成为一个新的流
        Stream.concat(stream1, stream2)
                .forEach(System.out::println);

    }
}