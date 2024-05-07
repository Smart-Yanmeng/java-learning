package com.york.pattern.adapter.object_adapter;

public class SDAdapterTF implements SDCard {

    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {

        System.out.println("adapter read TF card");

        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {

        System.out.println("adapter write TF card");
        tfCard.writeTF(msg);
    }
}
