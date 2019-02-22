package state;

public abstract class LiftState {
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    abstract public void open();
    abstract public void close();
    abstract public void run();
    abstract public void stop();

    public Context getContext() {
        return context;
    }
}
