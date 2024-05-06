package com.york.pattern.factory.config_factory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class CoffeeFactory {

    private static HashMap<String, Coffee> map = new HashMap<String, Coffee>();

    static {
        Properties p = new Properties();

        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            p.load(is);

            Set<Object> keys = p.keySet();

            for (Object key : keys) {

                // 获取类名
                String className = p.getProperty(key.toString());

                // 通过反射创建对象
                Class clazz = Class.forName(className);
                Coffee coffee = (Coffee) clazz.newInstance();

                // 将对象放入map中
                map.put(key.toString(), coffee);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Coffee createCoffee(String name) {

        return map.get(name);
    }
}
