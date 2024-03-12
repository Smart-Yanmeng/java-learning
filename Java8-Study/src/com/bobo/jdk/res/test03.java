package com.bobo.jdk.res;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class test03 {
    public static void main(String[] args) {
        /**
         * 线程安全问题的解决方法
         */
        // 加同步锁
        List<Integer> listNew = new ArrayList<>();
        Object obj = new Object();
        IntStream.rangeClosed(0, 999)
                .parallel()
                .forEach(i -> {
                    synchronized (obj) {
                        listNew.add(i);
                    }
                });
        System.out.println(listNew.size());

        // 使用线程安全容器 Vector
        Vector v = new Vector();
        IntStream.rangeClosed(0, 999)
                .parallel()
                .forEach(v::add);
        System.out.println(v.size());

        // 将线程不安全的容器包装为线程安全容器
        List<Integer> listNew2 = new ArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(listNew2);
        IntStream.rangeClosed(0, 999)
                .parallel()
                .forEach(synchronizedList::add);
        System.out.println(synchronizedList.size());

        // 通过 Stream 中的 toArray 方法或者 collect 方法来操作
        List<Integer> listNew3 = IntStream.rangeClosed(0, 999)
                .parallel()
                .boxed()
                .collect(Collectors.toList());
        System.out.println(listNew3.size());
    }
}
