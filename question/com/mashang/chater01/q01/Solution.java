package com.mashang.chater01.q01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        ArrayList<Student> studentList = new ArrayList<Student>();

        while (true) {
            boolean flag = true;
            String line = in.readLine();

            if (line.isEmpty()) {
                break;
            }

            String[] parts = line.split(" ");
            for (Student s : studentList) {
                if (Objects.equals(s.getNumber(), parts[0]) && Objects.equals(s.getName(), parts[1])) {
                    flag = false;

                    setScore(parts, s);
                }
            }

            if (flag) {
                studentList.add(new Student(parts[0], parts[1]));
                setScore(parts, studentList.get(studentList.size() - 1));
            }
        }

        for (Student s : studentList) {
            out.printf("%s %s %d %.2f\n", s.getNumber(), s.getName(), s.calcTotalScore(), s.calcAverageScore());
            out.flush();
        }
    }

    private static void setScore(String[] parts, Student s) {
        switch (parts[2]) {
            case "语文" -> s.setCScore(Double.parseDouble(parts[3]), Double.parseDouble(parts[4]));
            case "数学" -> s.setMScore(Double.parseDouble(parts[3]), Double.parseDouble(parts[4]));
            case "物理" -> s.setPScore(Double.parseDouble(parts[3]), Double.parseDouble(parts[4]));
        }
    }
}
