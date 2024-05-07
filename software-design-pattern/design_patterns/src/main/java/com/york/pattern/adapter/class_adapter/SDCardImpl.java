package com.york.pattern.adapter.class_adapter;

public class SDCardImpl implements SDCard {

    @Override
    public String readSD() {
        return "SDCard read msg: hello word SDCard";
    }

    @Override
    public void writeSD(String msg) {

        System.out.println("SDCard write msg: " + msg);
    }
}
