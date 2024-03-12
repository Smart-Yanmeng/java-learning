package com.mashang.util;

import com.mashang.test.Test05;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReadBean {

    private static Map<String, Object> map = new HashMap<String, Object>();

    static {
        try {
            // 创建 SAXReader 对象
            SAXReader saxReader = new SAXReader();

            // 获取整个 xml 文档
            Document document = saxReader.read(Test05.class.getClassLoader().getResource("spring.xml"));

            // 获取到根节点
            Element rootElement = document.getRootElement();

            // 获取 rootElement 的迭代器
            Iterator<Element> rootIterator = rootElement.elementIterator();

            while (rootIterator.hasNext()) {
                // entity 这个元素
                Element element = rootIterator.next();

                if ("entity".equals(element.getName())) {
                    // 读取里面的属性, 然后创建出对象
                    Attribute idAttribute = element.attribute("id");
//                    System.out.println(idAttribute.getValue());

                    Attribute classAttribute = element.attribute("class");
//                    System.out.println(classAttribute.getValue());

                    // 获取 Class 对象
                    Class cls = Class.forName(classAttribute.getValue());

                    // 获取构造器
                    Constructor constructor = cls.getConstructor();
                    Object object = constructor.newInstance();

                    // 继续解析当前元素的子元素
                    Iterator<Element> entityIterator = element.elementIterator();
                    while (entityIterator.hasNext()) {
                        Element columnElement = entityIterator.next();
                        // 获取属性 name 里的值, 然后给对象中的属性赋值
                        Attribute nameAttribute = columnElement.attribute("name");
//                        System.out.println("name = " + nameAttribute.getValue());

                        // 获取 column 属性中 value 的值
                        Attribute valueAttribute = columnElement.attribute("value");
//                        System.out.println("value = " + valueAttribute.getValue());

                        Field field = cls.getDeclaredField(nameAttribute.getValue());
                        field.setAccessible(true);

                        // 判断如果数据类型为整形, 则将数据转为 Integer
//                        if ("java.lang.Integer".equals(field.getType().getName())) {
//                            field.set(object, Integer.valueOf(valueAttribute.getValue()));
//                        } else {
//                            field.set(object, valueAttribute.getValue());
//                        }

                        // 判断属性类型
                        switch (field.getType().getName()) {
                            case "java.lang.Integer":
                                field.set(object, Integer.valueOf(valueAttribute.getValue()));
                                break;
                            case "java.lang.Long":
                                field.set(object, Long.valueOf(valueAttribute.getValue()));
                                break;
                            default:
                                field.set(object, valueAttribute.getValue());
                                break;
                        }
                    }

                    map.put(idAttribute.getValue(), object);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String beanId) {
        return map.get(beanId);
    }
}
