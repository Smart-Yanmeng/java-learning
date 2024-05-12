package com.york.pattern.observer.jdk;

import java.util.Observable;

public class Thief extends Observable {

    private String name;

    public Thief(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void steal() {
        System.out.println(name + "偷东西了");
        super.setChanged();
        super.notifyObservers();
    }
}
