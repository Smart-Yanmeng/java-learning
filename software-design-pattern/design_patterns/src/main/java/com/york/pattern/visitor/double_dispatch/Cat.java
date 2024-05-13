package com.york.pattern.visitor.double_dispatch;

public class Cat extends Animal {

    @Override
    public void accept(Execute execute) {
        execute.execute(this);
    }
}
