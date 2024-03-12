package com.bobo.jdk.res;

import java.util.Optional;

public class test05 {
    public static void main(String[] args) {
        String userName = null;
        if (userName != null) {
            System.out.println("字符串的长度为：" + userName.length());
        } else {
            System.out.println("字符串为空");
        }

        /**
         * Optional 对象的创建方式
         */
        // 通过 of 方法，不支持 null
        Optional<String> op1 = Optional.of("zhangsan");
//        Optional<Object> op2 = Optional.of(null);

        // 第二种方式通过 ofNullable 方法，支持 null
        Optional<String> op3 = Optional.ofNullable("lisi");
        Optional<String> op4 = Optional.ofNullable(null);

        // 第三种方式通过 empty 方法直接创建一个空的 Optional 对象
        Optional<Object> op5 = Optional.empty();

        /**
         * Optional 中的常用方法介绍
         *    get() 如果 Optional 有值则返回，否则抛出 NoSuchElementException 异常
         *    get() 通常和 isPresent 方法一块用
         * isPresent(): 是否包含值，包含值返回 true，不包含值返回 false
         * orElse(T t): 如果调用对象包含值，就返回该值，否则返回 t
         * orElseGet(Supplier s): 如果调用对象包含值，就返回该值，否则返回 Lambda 表达式的返回值
         */
        Optional<String> op6 = Optional.of("zhangsan");
        Optional<String> op7 = Optional.empty();

        // 获取 Optional 中的值
        if (op6.isPresent()) {
            String s1 = op6.get();
            System.out.println("用户名称：" + s1);
        }

        if (op7.isPresent()) {
            System.out.println(op7.get());
        } else {
            System.out.println("op7 是一个空的 Optional 对象");
        }

        String s3 = op6.orElse("李四");
        System.out.println(s3);
        Object s4 = op7.orElse("王五");
        System.out.println(s4);

        String s5 = op7.orElseGet(() -> {
            return "Hello";
        });
        System.out.println(s5);
    }
}
