package com.york.pattern.singleton.demo07;

import java.io.*;

/**
 * 通过序列化和反序列化破坏单例
 */
public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        writeObject2File();
        readObjectFromFile();
        readObjectFromFile();
    }

    public static void readObjectFromFile() throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\yorky\\Desktop\\STUDY\\java-learning\\software-design-pattern\\design_patterns\\src\\main\\java\\com\\york\\pattern\\singleton\\demo07\\tmp.txt"));

        Singleton instance = (Singleton) ois.readObject();

        System.out.println(instance);

        ois.close();
    }

    public static void writeObject2File() throws IOException {

        Singleton instance = Singleton.getInstance();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\yorky\\Desktop\\STUDY\\java-learning\\software-design-pattern\\design_patterns\\src\\main\\java\\com\\york\\pattern\\singleton\\demo07\\tmp.txt"));

        oos.writeObject(instance);

        oos.close();
    }
}
