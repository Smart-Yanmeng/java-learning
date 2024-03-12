package com.bobo.jdk.stream;

import java.util.stream.Stream;

public class StreamTest13Sorted {
    public static void main(String[] args) {
        Stream.of("1", "4", "7", "2", "9", "6")
                .map(Integer::parseInt)
//                .sorted() // 根据数据的自然排序顺序
                .sorted((o1, o2) -> o2 - o1) // 根据比较器指定排序规则
                .forEach(System.out::println);
    }
}