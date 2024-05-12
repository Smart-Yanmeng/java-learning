package com.york.pattern.iterator;

import java.util.List;

public class StudentIteratorImpl implements StudentIterator {

    private final List<Student> list;

    private int index = 0;

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Student next() {

        Student current = list.get(index);
        index++;

        return current;
    }
}
