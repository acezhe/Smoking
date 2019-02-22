package state;

public class Context {
    public static final OpeningState OPENING_STATE = new OpeningState();
    public static final ClosingState CLOSING_STATE = new ClosingState();
    public static final RunningState RUNNING_STATE = new RunningState();
    public static final StoppingState STOPPING_STATE = new StoppingState();

    private LiftState curState = STOPPING_STATE;

    public Context(){
        curState.setContext(this);
    }

    public Context(LiftState curState) {
        this.curState = curState;
    }

    public void open(){
        curState.open();
    }

    public void close(){
        curState.close();
    }

    public void run(){
        curState.run();
    }

    public void stop(){
        curState.stop();
    }

    public LiftState getCurState(){
        return curState;
    }

    public void setCurState(LiftState curState) {
        this.curState = curState;
        this.curState.setContext(this);
    }
}
