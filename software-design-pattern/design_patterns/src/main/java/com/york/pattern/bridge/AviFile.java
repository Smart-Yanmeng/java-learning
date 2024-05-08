package com.york.pattern.bridge;

public class AviFile implements VideoFile {

    @Override
    public void decode(String fileName) {
        System.out.println("avi file: " + fileName);
    }
}
