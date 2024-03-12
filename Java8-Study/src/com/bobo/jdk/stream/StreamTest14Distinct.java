package com.bobo.jdk.stream;

import java.util.stream.Stream;

public class StreamTest14Distinct {
    public static void main(String[] args) {
        Stream.of("1", "4", "1", "1", "9", "6")
                .distinct() // 去掉重复记录
                .forEach(System.out::println);
    }
}