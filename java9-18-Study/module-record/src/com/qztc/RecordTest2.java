package com.qztc;

public record RecordTest2(String name, Integer age) {
    public RecordTest2 {
        System.out.println("My name is " + name);
    }
}
