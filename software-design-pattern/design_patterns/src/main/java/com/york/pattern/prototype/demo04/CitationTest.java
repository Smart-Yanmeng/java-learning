package com.york.pattern.prototype.demo04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CitationTest {

    public static void main(String[] args) throws Exception {

        Citation c1 = new Citation();
        Student student1 = new Student();
        student1.setName("张三");
        c1.setStudent(student1);

        // 通过序列化和反序列化实现深克隆
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\yorky\\Desktop\\STUDY\\java-learning\\software-design-pattern\\design_patterns\\src\\main\\java\\com\\york\\pattern\\prototype\\demo04\\tmp.txt"));
        oos.writeObject(c1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\yorky\\Desktop\\STUDY\\java-learning\\software-design-pattern\\design_patterns\\src\\main\\java\\com\\york\\pattern\\prototype\\demo04\\tmp.txt"));
        Citation c2 = (Citation) ois.readObject();
        ois.close();

        c2.getStudent().setName("李四");

        System.out.println(c1.getStudent().getName());
        System.out.println(c2.getStudent().getName());
    }
}
