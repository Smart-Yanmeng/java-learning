package com.york.pattern.command;

public class Client {

    public static void main(String[] args) {

        Order order1 = new Order();
        order1.setDiningTable(1);
        order1.setFood("鱼香肉丝", 1);
        order1.setFood("红烧肉", 2);

        Order order2 = new Order();
        order2.setDiningTable(2);
        order2.setFood("鱼香肉丝", 1);
        order2.setFood("红烧肉", 2);
        order2.setFood("糖醋排骨", 1);

        SeniorChef seniorChef = new SeniorChef();

        OrderCommand orderCommand1 = new OrderCommand(seniorChef, order1);
        OrderCommand orderCommand2 = new OrderCommand(seniorChef, order2);

        Waiter waiter = new Waiter();
        waiter.setCommand(orderCommand1);
        waiter.setCommand(orderCommand2);

        waiter.notifyCommand();
    }
}
