package com.york.pattern.flyweight;

import java.util.HashMap;

public class BoxFactory {

    private final HashMap<String, AbstractBox> boxMap;

    private static final BoxFactory factory = new BoxFactory();

    private BoxFactory() {
        boxMap = new HashMap<String, AbstractBox>();
        boxMap.put("I", new IBox());
        boxMap.put("L", new LBox());
        boxMap.put("O", new OBox());
    }

    public static BoxFactory getInstance() {
        return factory;
    }

    public AbstractBox getShape(String name) {
        return boxMap.get(name);
    }
}
