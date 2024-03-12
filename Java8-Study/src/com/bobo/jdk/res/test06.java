package com.bobo.jdk.res;

import com.bobo.jdk.lambda.domain.Person;

import java.util.Optional;

public class test06 {
    public static void main(String[] args) {
        Optional<String> op1 = Optional.of("zhangsan");
        Optional<Object> op2 = Optional.empty();

        // 如果存在值，就做什么
        op1.ifPresent(System.out::println);

        /**
         * 自定义一个方法，将 Person 对象中的 name 转换为大写并返回
         */
        Person p = new Person("zhangsan", 18);
        Optional<Person> op = Optional.of(p);

        String name = getNameForOptional(op);
        System.out.println(name);
    }

    /**
     * 根据 Person 对象，将 name 转换为大写并返回
     * 通过 Optional 方式
     *
     * @param op
     * @return
     */
    public static String getNameForOptional(Optional<Person> op) {
        if (op.isPresent()) {
            return op.map(Person::getName)
                    .map(String::toUpperCase)
                    .orElse(null);
        }
        return null;
    }

    /**
     * 根据 Person 对象，将 name 转换为大写并返回
     *
     * @param person
     * @return
     */
    public String getName(Person person) {
        if (person != null) {
            if (person.getName() != null) return person.getName().toUpperCase();
            else return null;
        } else return null;
    }
}
