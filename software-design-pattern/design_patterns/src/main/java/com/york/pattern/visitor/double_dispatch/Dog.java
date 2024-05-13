package com.york.pattern.visitor.double_dispatch;

public class Dog extends Animal {

    @Override
    public void accept(Execute execute) {
        execute.execute(this);
    }
}
