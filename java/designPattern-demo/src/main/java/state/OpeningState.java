package state;

public class OpeningState extends LiftState{

    @Override
    public void open() {
        System.out.println("lift is opening!");
    }

    @Override
    public void close() {
        getContext().setCurState(Context.CLOSING_STATE);
        getContext().getCurState().close();
    }

    @Override
    public void run() {
        System.out.println("lift is opening,can't running!");
    }

    @Override
    public void stop() {
        System.out.println("lift is opening,needn't stopping!");
    }
}
