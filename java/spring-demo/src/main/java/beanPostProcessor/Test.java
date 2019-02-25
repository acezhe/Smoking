package beanPostProcessor;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class Test {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerShutdownHook();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("beanPostProcessor.xml");
        context.refresh();

        SimpleBean bean = (SimpleBean) context.getBean("simpleBean");
        System.out.println(bean.getMessage());
    }
}
