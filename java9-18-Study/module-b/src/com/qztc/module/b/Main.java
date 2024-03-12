package com.qztc.module.b;

import com.qztc.module.a.animal.Animal;
//import com.qztc.module.a.person.Person;

public class Main {
    public static void main(String[] args) throws Exception {
        Animal animal = new Animal();
        animal.exec();
        // 若 module a 中没有导出 Person, 则 module b 就无法访问，即使是反射也无法访问
//        Person person = new Person();

        // module b 中使用反射也无法访问到
        Class<?> clazz = Class.forName("com.qztc.module.a.person.Person");
        Object o = clazz.newInstance();
        System.out.println(o.hashCode());
    }
}
