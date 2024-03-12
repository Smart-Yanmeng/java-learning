package com.bobo.jdk.stream;

import java.util.stream.Stream;

public class StreamTest20MapToInt {
    public static void main(String[] args) {
        // Integer 占用的内存比 int 多很多，在 Stream 流操作中会自动装箱和拆箱操作
        Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        Stream.of(arr)
                .filter(i  -> i > 0)
                .forEach(System.out::println);
        // 为了提高程序代码效率，我们可以先将流中的 Integer 数据转换为 int 数据，然后再操作
        Stream.of(arr)
                .mapToInt(Integer::intValue)
                .forEach(System.out::println);
    }
}