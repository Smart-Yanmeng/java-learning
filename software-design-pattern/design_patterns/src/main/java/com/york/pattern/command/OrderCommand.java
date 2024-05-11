package com.york.pattern.command;

public class OrderCommand implements Command {

    private SeniorChef seniorChef;

    private Order order;

    public OrderCommand(SeniorChef seniorChef, Order order) {
        this.seniorChef = seniorChef;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.getDiningTable() + "号桌的菜单：");
        order.getFoodDir().forEach((k, v) -> seniorChef.makeFood(k, v));
        System.out.println(order.getDiningTable() + "号桌的菜已经上齐");
    }
}
