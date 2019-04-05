package startupAndShutdownCallback;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.Phased;
import org.springframework.context.SmartLifecycle;

public class DaemonBeanHighPrior implements SmartLifecycle, Phased, BeanNameAware {


    private boolean isRunning = false;
    private String beanName;

    public void init() {
        System.out.println(beanName + " init!");
    }

    public void dispose() {
        System.out.println(beanName + " dispose!");
    }

    @Override
    public void start() {
        isRunning = true;
        System.out.println(beanName + " is start!");
    }

    @Override
    public void stop() {
        isRunning = false;
        System.out.println(beanName + " is stop!");
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public int getPhase() {
        return -2;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
