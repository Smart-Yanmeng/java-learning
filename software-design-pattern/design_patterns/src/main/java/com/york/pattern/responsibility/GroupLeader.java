package com.york.pattern.responsibility;

public class GroupLeader extends Handler {

    public GroupLeader() {
        super(0, Handler.NUM_THREE);
    }

    @Override
    protected void handleRequest(LeaveRequest request) {
        System.out.println("组长审批" + request.getName() + "的请假" + request.getDays() + "天，" + request.getReason());
    }
}
