package com.bobo.jdk.res;

import com.bobo.jdk.lambda.domain.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test01 {
    public static void main(String[] args) {
        // 收集到 List 集合中
        List<String> list = Stream.of("aa", "bb", "cc", "aa")
                .collect(Collectors.toList());
        System.out.println(list);

        // 收集到 Set 集合中
        Set<String> set = Stream.of("aa", "bb", "cc", "aa")
                .collect(Collectors.toSet());
        System.out.println(set);

        // 如果需要获取的类型为具体的实现，比如：ArrayList、HashSet
        ArrayList<String> arrayList = Stream.of("aa", "bb", "cc", "aa")
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(arrayList);

        HashSet<String> hashSet = Stream.of("aa", "bb", "cc", "aa")
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(hashSet);

        // 收集到数组中
        Object[] objects = Stream.of("aa", "bb", "cc", "aa")
                .toArray(); // 返回的数组中的元素是 Object 类型
        System.out.println(Arrays.toString(objects));

        // 如果我们需要指定返回的数组中的元素类型
        String[] strings = Stream.of("aa", "bb", "cc", "aa")
                .toArray(String[]::new);
        System.out.println(Arrays.toString(strings));

        /**
         * Stream 流中数据的聚合计算
         */
        // 获取年龄的最大值
        Optional<Person> maxAge = Stream.of(
                new Person("张三", 18)
                , new Person("李四", 20)
                , new Person("王五", 13)
                , new Person("老六", 16)
                , new Person("七七", 77)
        ).collect(Collectors.maxBy(Comparator.comparing(Person::getAge)));
        System.out.println("最大年龄是：" + maxAge);

        // 获取年龄的最小值
        Optional<Person> minAge = Stream.of(
                new Person("张三", 18)
                , new Person("李四", 20)
                , new Person("王五", 13)
                , new Person("老六", 16)
                , new Person("七七", 77)
        ).collect(Collectors.minBy(Comparator.comparing(Person::getAge)));
        System.out.println("最小年龄是：" + minAge);

        // 求所有人的年龄之和
        Integer sumAge = Stream.of(
                new Person("张三", 18)
                , new Person("李四", 20)
                , new Person("王五", 13)
                , new Person("老六", 16)
                , new Person("七七", 77)
        ).collect(Collectors.summingInt(Person::getAge));
        System.out.println("年龄总和为：" + sumAge);

        // 求所有人年龄的平均值
        Double averageAge = Stream.of(
                new Person("张三", 18)
                , new Person("李四", 20)
                , new Person("王五", 13)
                , new Person("老六", 16)
                , new Person("七七", 77)
        ).collect(Collectors.averagingInt(Person::getAge));
        System.out.println("平均年龄为：" + averageAge);

        // 统计数量
        Long count = Stream.of(
                new Person("张三", 18)
                , new Person("李四", 20)
                , new Person("王五", 13)
                , new Person("老六", 16)
                , new Person("七七", 77)
        ).collect(Collectors.counting());
        System.out.println("数量为：" + count);

        /**
         * 分组计算
         */
        // 根据账号对数据进行分组
        Map<String, List<Person>> map1 = Stream.of(
                new Person("张三", 18, 175)
                , new Person("李四", 20, 160)
                , new Person("张三", 13, 165)
                , new Person("张三", 16, 180)
                , new Person("李四", 77, 120)
        ).collect(Collectors.groupingBy(Person::getName));
        map1.forEach((k, v) -> System.out.println("姓名 = " + k + " 详细信息 = " + v));

        // 根据年龄分组，如果大于等于18，则成年，否则未成年
        Map<String, List<Person>> map2 = Stream.of(
                new Person("张三", 18, 175)
                , new Person("李四", 20, 160)
                , new Person("张三", 13, 165)
                , new Person("张三", 16, 180)
                , new Person("李四", 77, 120)
        ).collect(Collectors.groupingBy(p -> {
            return p.getAge() >= 18 ? "成年" : "未成年";
        }));
        map2.forEach((k, v) -> System.out.println("姓名 = " + k + " 详细信息 = " + v));

        // 多级分组
        // 先根据 name 分组，然后根据 age（成年和未成年）分组
        Map<String, Map<String, List<Person>>> group = Stream.of(
                new Person("张三", 18, 175)
                , new Person("李四", 20, 160)
                , new Person("张三", 13, 165)
                , new Person("张三", 16, 180)
                , new Person("李四", 77, 120)
        ).collect(Collectors.groupingBy(
                Person::getName
                , Collectors.groupingBy(p -> p.getAge() >= 18 ? "成年" : "未成年"
                )
        ));
        group.forEach((k, v) -> {
            System.out.println(k);
            v.forEach((k1, v1) -> {
                System.out.println("\t" + k1 + " = " + v1);
            });
        });

        /**
         * 分区操作
         */
        Map<Boolean, List<Person>> map3 = Stream.of(
                new Person("张三", 18, 175)
                , new Person("李四", 20, 160)
                , new Person("张三", 13, 165)
                , new Person("张三", 16, 180)
                , new Person("李四", 77, 120)
        ).collect(Collectors.partitioningBy(p -> p.getAge() >= 18));
        map3.forEach((k, v) -> System.out.println(k + "\t" + v));

        /**
         * 拼接操作
         */
        String s1 = Stream.of(
                new Person("张三", 18, 175)
                , new Person("李四", 20, 160)
                , new Person("张三", 13, 165)
                , new Person("张三", 16, 180)
                , new Person("李四", 77, 120)
        ).map(Person::getName).collect(Collectors.joining());
        System.out.println(s1);

        String s2 = Stream.of(
                new Person("张三", 18, 175)
                , new Person("李四", 20, 160)
                , new Person("张三", 13, 165)
                , new Person("张三", 16, 180)
                , new Person("李四", 77, 120)
        ).map(Person::getName).collect(Collectors.joining("_"));
        System.out.println(s2);

        String s3 = Stream.of(
                new Person("张三", 18, 175)
                , new Person("李四", 20, 160)
                , new Person("张三", 13, 165)
                , new Person("张三", 16, 180)
                , new Person("李四", 77, 120)
        ).map(Person::getName).collect(Collectors.joining("_", "###", "$$$"));
        System.out.println(s3);
    }
}
