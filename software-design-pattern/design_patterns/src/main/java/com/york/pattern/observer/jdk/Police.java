package com.york.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class Police implements Observer {

    private String name;

    public Police(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this.getName() + ": " + ((Thief) o).getName() + "偷东西了");
    }
}
