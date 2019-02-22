package state;

public class ClosingState extends LiftState {

    @Override
    public void open() {
        getContext().setCurState(Context.OPENING_STATE);
        getContext().getCurState().open();
    }

    @Override
    public void close() {
        System.out.println("lift is closing!");
    }

    @Override
    public void run() {
        getContext().setCurState(Context.RUNNING_STATE);
        getContext().getCurState().run();
    }

    @Override
    public void stop() {
        getContext().setCurState(Context.STOPPING_STATE);
        getContext().getCurState().stop();
    }
}
