package com.york.pattern.prototype.demo03;

public class Citation implements Cloneable {

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
