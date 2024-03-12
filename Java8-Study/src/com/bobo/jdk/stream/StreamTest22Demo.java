package com.bobo.jdk.stream;

import com.bobo.jdk.lambda.domain.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest22Demo {

    /**
     * 1. 第一个队伍只保留姓名长度为3的成员
     * 2. 第一个队伍筛选之后只要前三个人
     * 3. 第二个队伍只要姓张的成员
     * 4. 第二个队伍筛选之后不要前两个人
     * 5. 将两个队伍合并为一个队伍
     * 6. 根据姓名创建Person对象
     * 7. 打印整个队伍的Person队伍
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子", "洪七公");
        List<String> list2 = Arrays.asList("古力娜扎", "张无忌 ", "张三丰", "赵丽颖", "张二狗", "张天爱", "张三");

        Stream<String> stream1 = list1.stream()
                .filter((String s) -> (s.length() == 3))
                .limit(3);
        Stream<String> stream2 = list2.stream()
                .filter((String s) -> s.startsWith("张"))
                .skip(2);

        Stream<String> stream3 = Stream.concat(stream1, stream2);

        Stream<Person> personStream = stream3.map(Person::new);

        personStream.forEach(System.out::println);
    }
}