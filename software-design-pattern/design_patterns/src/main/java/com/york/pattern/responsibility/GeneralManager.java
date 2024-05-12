package com.york.pattern.responsibility;

public class GeneralManager extends Handler {

    public GeneralManager() {
        super(Handler.NUM_THREE, Handler.NUM_SEVEN);
    }

    @Override
    protected void handleRequest(LeaveRequest request) {
        System.out.println("总经理审批" + request.getName() + "的请假" + request.getDays() + "天，" + request.getReason());
    }
}
