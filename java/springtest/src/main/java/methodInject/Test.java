package methodInject;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class Test {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("methodInjectConfig.xml");
        context.refresh();

        BeInjector beInjector = (BeInjector) context.getBean("beInjector");
        // 调用 3 次，看看是否每次调用都生成了新的 Injector 对象
        for (int i=0;i<3;i++){
            beInjector.useInjector();
        }
    }
}
