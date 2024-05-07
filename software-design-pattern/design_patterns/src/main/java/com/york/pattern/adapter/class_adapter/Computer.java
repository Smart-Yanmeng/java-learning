package com.york.pattern.adapter.class_adapter;

public class Computer {

    String readSD(SDCard sdCard) {

        if (sdCard == null) {
            throw new NullPointerException("sd card is null");
        }

        return sdCard.readSD();
    }
}
