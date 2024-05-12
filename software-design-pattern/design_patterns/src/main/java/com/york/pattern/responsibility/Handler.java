package com.york.pattern.responsibility;

public abstract class Handler {

    protected final static int NUM_ONE = 1;
    protected final static int NUM_THREE = 3;
    protected final static int NUM_SEVEN = 7;

    private int numStart;

    private int numEnd;

    protected Handler nextHandler;

    public Handler(int numStart) {
        this.numStart = numStart;
    }

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract void handleRequest(LeaveRequest request);

    public final void submit(LeaveRequest request) {

        this.handleRequest(request);

        if (this.nextHandler != null && request.getDays() > this.numEnd) {
            this.nextHandler.submit(request);
        } else {
            System.out.println("审批不通过");
        }
    }
}
