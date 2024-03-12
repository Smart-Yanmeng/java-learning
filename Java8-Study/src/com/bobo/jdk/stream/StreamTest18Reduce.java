package com.bobo.jdk.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest18Reduce {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        String reduce = list.stream()
                // identity 默认值
                // 第一次的时候会将默认值赋给 x
                // 之后每次会将上一次的操作结果赋值给 x，y 就是每次从数据中获取的元素
                .reduce("", (x, y) -> x + y);
        System.out.println(reduce);

        // 用 reduce 实现求 max
        String max = list.stream()
                .reduce("", (x, y) -> x.compareTo(y) > 0 ? x: y);
        System.out.println(max);
    }
}