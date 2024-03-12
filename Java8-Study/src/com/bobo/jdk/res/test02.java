package com.bobo.jdk.res;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class test02 {
    public static void main(String[] args) {
        /**
         * 串行流
         */
        Stream.of(5, 6, 8, 3, 1, 6)
                .filter(s -> {
                    System.out.println(Thread.currentThread() + "" + s);
                    return s > 3;
                }).count();

        /**
         * 获取并行流的两种方式
         */
        List<Integer> list = new ArrayList<>();
        // 通过 List 接口直接获取并行流
        Stream<Integer> integerStream = list.parallelStream();

        // 将已有的串行流转换为并行流
        Stream<Integer> parallel = Stream.of(1, 2, 3).parallel();

        /**
         * 并行流操作
         */
        Stream.of(1, 4, 2, 6, 1, 5, 9)
                .parallel() // 将流转换为并发流，Stream处理的时候就会通过多线程处理
                .filter(s -> {
                    System.out.println(Thread.currentThread() + " s = " + s);
                    return s > 2;
                }).count();
    }
}
