package methodInject;

/**
 * 使用非单例对象的单例 bean。为使用方法注入，该类必须是抽象的
 */
public abstract class BeInjector {

    /**
     * 调用 getInjector 获取 Injector 对象，并调用其方法。
     * Injector 对象的具体生成是由 Spring 管理的。
     */
    public void useInjector(){
        Injector injector = getInjector();
        injector.printName();
    }

    /**
     * 生成 {@link Injector} 对象
     * @return Injector 对象
     */
    protected abstract Injector getInjector();
}
