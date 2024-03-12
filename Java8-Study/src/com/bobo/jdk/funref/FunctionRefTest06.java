package com.bobo.jdk.funref;

import com.bobo.jdk.lambda.domain.Person;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class FunctionRefTest06 {

    public static void main(String[] args) {
        Supplier<Person> sup1 = () -> {
            return new Person();
        };
        System.out.println(sup1.get());

        // 方法引用
        Supplier<Person> sup2 = Person::new;
        System.out.println(sup2.get());
        BiFunction<String, Integer, Person> function = Person::new;
        System.out.println(function.apply("张三", 22));
    }
}
