package state;

public class StoppingState extends LiftState{

    @Override
    public void open() {
        getContext().setCurState(Context.OPENING_STATE);
        getContext().getCurState().open();
    }

    @Override
    public void close() {
        System.out.println("lift is stopping,needn't close.");
    }

    @Override
    public void run() {
        getContext().setCurState(Context.RUNNING_STATE);
        getContext().getCurState().run();
    }

    @Override
    public void stop() {
        System.out.println("lift is stopping.");
    }
}
