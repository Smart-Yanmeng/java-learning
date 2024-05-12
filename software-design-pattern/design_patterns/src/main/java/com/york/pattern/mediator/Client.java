package com.york.pattern.mediator;

public class Client {

    public static void main(String[] args) {

        MediatorStructure mediator = new MediatorStructure();

        Tenant tenant = new Tenant("小明", mediator);

        HouseOwner houseOwner = new HouseOwner("小王", mediator);

        mediator.setHouseOwner(houseOwner);
        mediator.setTenant(tenant);

        tenant.contact("我想租房子");
        houseOwner.contact("我有房子出租");
    }
}
