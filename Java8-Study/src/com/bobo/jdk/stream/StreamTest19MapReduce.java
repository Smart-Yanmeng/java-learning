package com.bobo.jdk.stream;

import com.bobo.jdk.lambda.domain.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest19MapReduce {
    public static void main(String[] args) {
        // 1.求出所有年龄的总和
        Integer sumAge = Stream.of(
                        new Person("张三", 18)
                        , new Person("李四", 20)
                        , new Person("王五", 13)
                        , new Person("老六", 16)
                        , new Person("七七", 77)
                )
                .map(Person::getAge)
                .reduce(0, Integer::sum);
        System.out.println(sumAge);

        // 2.求出所有年龄中的最大值
        Integer maxAge = Stream.of(
                        new Person("张三", 18)
                        , new Person("李四", 20)
                        , new Person("王五", 13)
                        , new Person("老六", 16)
                        , new Person("七七", 77)
                )
                .map(Person::getAge)
                .reduce(0, Math::max);
        System.out.println(maxAge);

        // 3.统计字符 a 出现的次数
        Integer reduce = Stream.of("a", "b", "c", "d", "a", "b", "a")
                .map(ch -> "a".equals(ch) ? 1 : 0)
                .reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}