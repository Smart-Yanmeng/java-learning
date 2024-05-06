package com.york.pattern.prototype.demo01;

public class RealizeType implements Cloneable {

    public RealizeType() {
        System.out.println("具体原型创建成功！");
    }

    @Override
    protected RealizeType clone() throws CloneNotSupportedException {

        System.out.println("具体原型复制成功！");

        return (RealizeType) super.clone();
    }
}
