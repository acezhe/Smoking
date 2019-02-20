package methodInject;

/**
 * 被注入的非单例对象
 */
public class Injector {
    public void printName(){
        System.out.println(this.toString());
    }
}
