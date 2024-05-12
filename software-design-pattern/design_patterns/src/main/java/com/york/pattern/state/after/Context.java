package com.york.pattern.state.after;

public class Context {

    public final static OpeningState OPENING_STATE = new OpeningState();

    public final static ClosingState CLOSING_STATE = new ClosingState();

    public final static RunningState RUNNING_STATE = new RunningState();

    public final static StoppingState STOPPING_STATE = new StoppingState();

    private LiftState liftState;

    public LiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        this.liftState.setContext(this);
    }

    public void open() {
        this.liftState.open();
    }

    public void close() {
        this.liftState.close();
    }

    public void run() {
        this.liftState.run();
    }

    public void stop() {
        this.liftState.stop();
    }
}
