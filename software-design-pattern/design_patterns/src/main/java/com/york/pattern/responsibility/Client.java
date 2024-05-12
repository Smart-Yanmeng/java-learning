package com.york.pattern.responsibility;

public class Client {

    public static void main(String[] args) {

        LeaveRequest request = new LeaveRequest("小明", 8, "回家探亲");

        Handler groupLeader = new GroupLeader();
        Handler manager = new Manager();
        Handler generalManager = new GeneralManager();

        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        groupLeader.submit(request);
    }
}
