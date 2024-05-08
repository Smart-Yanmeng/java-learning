package com.york.pattern.bridge;

public class Client {

    public static void main(String[] args) {

        OperatingSystem mac = new Mac(new AviFile());
        mac.play("movie.avi");
    }
}
