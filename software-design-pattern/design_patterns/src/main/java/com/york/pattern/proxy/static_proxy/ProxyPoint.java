package com.york.pattern.proxy.static_proxy;

public class ProxyPoint implements SellTickets {

    private TrainStation mTrainStation = new TrainStation();

    @Override
    public void sell() {
        System.out.println("代售点卖票");

        mTrainStation.sell();
    }
}
