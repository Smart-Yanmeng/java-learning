package com.york.pattern.state.after;

public class RunningState extends LiftState {

    @Override
    public void open() {
    }

    @Override
    public void close() {
    }

    @Override
    public void run() {
        System.out.println("电梯运行");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.STOPPING_STATE);
        super.context.getLiftState().stop();
    }
}
