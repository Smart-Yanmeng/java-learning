package com.mashang.test;

import com.mashang.model.Student;
import com.mashang.util.ReadBean;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class Test05 {

    public static void main(String[] args) {
        ReadBean readBean = new ReadBean();

        Student stu = (Student) readBean.getBean("student");
        System.out.println(stu);
    }
}
