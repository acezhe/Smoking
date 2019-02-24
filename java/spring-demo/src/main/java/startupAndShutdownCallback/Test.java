package startupAndShutdownCallback;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;


/**
 * 通过让 bean 实现 {@link org.springframework.context.SmartLifecycle} 接口中的方法，可以使 bean 在容器启动和停止时
 * 执行一些操作。比如当做守护线程用。
 */
public class Test {
    private static final int WAIT_TIME = 3000;
    public static void main(String[] args) throws InterruptedException {

        System.out.println("first start! 初始化 bean，按配置顺序初始化 daemon bean");
        // 创建容器，创建完成后容器会自动启动,随容器启动的 bean 会按 phased 配置的顺序自动启动，数字越小启动越早
        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("startupAndShutdownCallback.xml");
        context.refresh();

        // 让随容器启动的线程运行
        Thread.sleep(WAIT_TIME);

        // 停止容器，daemon bean 的 stop 方法会被调用，线程会按 phased 配置的相反顺序停止
        System.out.println("stop! 暂停，daemon bean 的 stop 方法被调用（按配置相反顺序）");
        context.stop();

        // 再次启动容器，模拟容器重启过程（初始化的 bean 都还在，只是让容器重新运作，可以从 bean 的 dispose 方法没被调用看出）
        Thread.sleep(WAIT_TIME);
        System.out.println("start！再次启动，再次触发 daemon bean 的 start 方法");
        context.start();

        // 关闭容器(bean 会被销毁，bean 的 dispose 方法被调用)
        Thread.sleep(WAIT_TIME);
        System.out.println("close! 关闭容器，不但触发 daemon bean 的 stop 方法，还触发 bean 的 dispose 方法");
        context.close();

        // 等待后再次启动(全新启动，bean 重新初始化，init 方法被调用）
        Thread.sleep(WAIT_TIME);
        System.out.println("start! 再次启动容器，相当于启动新容器的步骤");
        context.start();

        // 等待后关闭容器，终止测试
        // TODO 第二次调用 close 居然不执行 stop 和 dispose 方法，难道是个 bug？
        Thread.sleep(WAIT_TIME);
        System.out.println("close! 关闭容器，效果有些问题。");
        context.close();
    }
}
