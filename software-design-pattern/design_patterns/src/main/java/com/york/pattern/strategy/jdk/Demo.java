package com.york.pattern.strategy.jdk;

import java.util.Arrays;
import java.util.Comparator;

public class Demo {

    public static void main(String[] args) {

        Integer[] data = {12, 2, 3, 2, 4, 5, 1};

        Arrays.sort(data, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.out.println(Arrays.toString(data));
    }
}
