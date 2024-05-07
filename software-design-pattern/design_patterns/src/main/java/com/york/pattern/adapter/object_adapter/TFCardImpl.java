package com.york.pattern.adapter.object_adapter;

public class TFCardImpl implements TFCard {
    @Override
    public String readTF() {

        return "TFCard read msg: hello word TFCard";
    }

    @Override
    public void writeTF(String msg) {

        System.out.println("TFCard write msg: " + msg);
    }
}
