package com.york.pattern.responsibility;

public class Manager extends Handler {

    public Manager() {
        super(Handler.NUM_ONE, Handler.NUM_THREE);
    }

    @Override
    protected void handleRequest(LeaveRequest request) {
        System.out.println("部门经理审批" + request.getName() + "的请假" + request.getDays() + "天，" + request.getReason());
    }
}
