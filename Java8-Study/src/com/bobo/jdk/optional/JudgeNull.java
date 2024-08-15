package com.bobo.jdk.optional;

import java.util.Optional;

public class JudgeNull {

    public static void main(String[] args) {

        /* 一般方法 */
        String userName = null;
        if (userName != null) {
            System.out.println("字符串的长度为：" + userName.length());
        } else {
            System.out.println("字符串为空");
        }

        /* Optional 类 */
        // 通过 of 方法，不支持 null
        Optional<String> op1 = Optional.of("zhangsan");
        // Optional<Object> op2 = Optional.of(null);

        // 第二种方式通过 ofNullable 方法，支持 null
        Optional<String> op3 = Optional.ofNullable("lisi");
        Optional<String> op4 = Optional.ofNullable(null);

        // 第三种方式通过 empty 方法直接创建一个空的 Optional 对象
        Optional<Object> op5 = Optional.empty();
    }
}
