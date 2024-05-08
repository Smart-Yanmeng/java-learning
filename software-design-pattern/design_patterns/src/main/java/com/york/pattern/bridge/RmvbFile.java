package com.york.pattern.bridge;

public class RmvbFile implements VideoFile {

    @Override
    public void decode(String fileName) {
        System.out.println("rmvb file: " + fileName);
    }
}
