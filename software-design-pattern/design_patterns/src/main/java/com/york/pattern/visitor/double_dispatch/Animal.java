package com.york.pattern.visitor.double_dispatch;

public class Animal {

    public void accept(Execute execute) {
        execute.execute(this);
    }
}
