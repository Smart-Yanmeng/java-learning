package com.york.pattern.prototype.demo02;

public class Citation implements Cloneable {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {

        return (Citation) super.clone();
    }
}
