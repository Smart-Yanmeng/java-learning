package com.york.pattern.iterator;

public class Client {

    public static void main(String[] args) {

        StudentAggregateImpl studentAggregate = new StudentAggregateImpl();
        studentAggregate.addStudent(new Student("小明", "001"));
        studentAggregate.addStudent(new Student("小红", "002"));
        studentAggregate.addStudent(new Student("小刚", "003"));

        StudentIterator studentIterator = studentAggregate.getIterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            System.out.println("学生姓名：" + student.getName() + "，学号：" + student.getNumber());
        }
    }
}
