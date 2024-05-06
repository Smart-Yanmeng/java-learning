package com.york.pattern.prototype.demo04;

import java.io.Serializable;

public class Citation implements Cloneable, Serializable {

    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {

        return (Citation) super.clone();
    }
}
