package state;

public class RunningState extends LiftState{

    @Override
    public void open() {
        System.out.println("lift is running,can't open the door!");
    }

    @Override
    public void close() {
        System.out.println("lift is running,the door was closed.");
    }

    @Override
    public void run() {
        System.out.println("lift is running!");
    }

    @Override
    public void stop() {
        getContext().setCurState(Context.STOPPING_STATE);
        getContext().getCurState().stop();
    }
}
