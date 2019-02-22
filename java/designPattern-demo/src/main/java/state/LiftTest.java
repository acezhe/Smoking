package state;

public class LiftTest {
    public static void main(String[] args) {
        Context context = new Context();
        context.run();
        context.open();
        context.stop();
        context.open();
        context.run();
        context.close();
    }
}
