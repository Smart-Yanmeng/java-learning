package com.mashang.chater01.q05;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student(2L, "John Doe", 25, "Mathematics"));
        students.add(new Student(2L, "Jane Smith", 30, "Physics"));
        students.add(new Student(3L, "Michael Johnson", 22, "Chemistry"));
        students.add(new Student(4L, "Emily Brown", 28, "Biology"));
        students.add(new Student(5L, "Emily Brown", 27, "Biology"));

        List<Student> dataList = removeDuplicateOrder(students);

        System.out.println(dataList);
    }

    private static List<Student> removeDuplicateOrder(List<Student> orderList) {
        Set<Student> set = new TreeSet<>((o1, o2) -> {
            if (!Objects.equals(o1.id(), o2.id())) return Long.compare(o1.age(), o2.age());
            else return o1.id().compareTo(o2.id());
        });
        set.addAll(orderList);
        return new ArrayList<>(set);
    }
}
