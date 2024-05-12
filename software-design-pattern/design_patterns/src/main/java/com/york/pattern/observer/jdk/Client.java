package com.york.pattern.observer.jdk;

public class Client {

    public static void main(String[] args) {

        Thief thief = new Thief("小蒋");
        Police police = new Police("小万");
        thief.addObserver(police);

        thief.steal();
    }
}
