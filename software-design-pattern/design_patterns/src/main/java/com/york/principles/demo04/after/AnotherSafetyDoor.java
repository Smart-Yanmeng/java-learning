package com.york.principles.demo04.after;

public class AnotherSafetyDoor implements AntiTheft, Fireproof {
    @Override
    public void antiTheft() {
        System.out.println("防盗");
    }

    @Override
    public void fireproof() {
        System.out.println("防火");
    }
}
