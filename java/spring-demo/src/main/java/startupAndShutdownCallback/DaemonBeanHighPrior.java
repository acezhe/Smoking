package startupAndShutdownCallback;

import org.springframework.context.Phased;
import org.springframework.context.SmartLifecycle;

public class DaemonBeanHighPrior implements SmartLifecycle, Phased {


    private boolean isRunning = false;

    public void init() {
        System.out.println(this.getClass().getSimpleName() + " init!");
    }

    public void dispose() {
        System.out.println(this.getClass().getSimpleName() + " dispose!");
    }

    @Override
    public void start() {
        isRunning=true;
        System.out.println(this.getClass().getSimpleName() + " is start!");
    }

    @Override
    public void stop() {
        isRunning = false;
        System.out.println(this.getClass().getSimpleName()+" is stop!");
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public int getPhase() {
        return -2;
    }
}
