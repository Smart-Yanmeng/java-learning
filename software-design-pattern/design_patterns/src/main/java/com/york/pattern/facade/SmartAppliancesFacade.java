package com.york.pattern.facade;

public class SmartAppliancesFacade {

    private final Light light;
    private final TV tv;
    private final AirCondition airCondition;

    public SmartAppliancesFacade() {
        this.light = new Light();
        this.tv = new TV();
        this.airCondition = new AirCondition();
    }

    public void on() {
        light.on();
        tv.on();
        airCondition.on();
    }

    public void off() {
        light.off();
        tv.off();
        airCondition.off();
    }

    public void say(String message) {
        if (message.contains("打开")) {
            on();
        } else if (message.contains("关闭")) {
            off();
        } else {
            System.out.println("无法识别的指令");
        }
    }
}
