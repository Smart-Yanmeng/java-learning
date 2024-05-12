package com.york.pattern.state.before;

public class Lift implements ILift {

    private int state;

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void open() {
        switch (state) {
            case OPENING_STATE:
            case STOPPING_STATE:
            case RUNNING_STATE:
                break;
            case CLOSING_STATE:
                System.out.println("电梯门开启");
                setState(OPENING_STATE);
                break;
        }
    }

    @Override
    public void close() {
        switch (state) {
            case CLOSING_STATE:
            case STOPPING_STATE:
            case RUNNING_STATE:
                break;
            case OPENING_STATE:
                System.out.println("电梯门关闭");
                setState(CLOSING_STATE);
                break;
        }
    }

    @Override
    public void run() {
        switch (state) {
            case RUNNING_STATE:
            case OPENING_STATE:
                break;
            case CLOSING_STATE:
            case STOPPING_STATE:
                System.out.println("电梯运行");
                setState(RUNNING_STATE);
                break;
        }
    }

    @Override
    public void stop() {
        switch (state) {
            case STOPPING_STATE:
            case OPENING_STATE:
            case CLOSING_STATE:
                break;
            case RUNNING_STATE:
                System.out.println("电梯停止");
                setState(STOPPING_STATE);
                break;
        }
    }
}
