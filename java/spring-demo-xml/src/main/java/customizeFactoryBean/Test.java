package customizeFactoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class Test {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerShutdownHook();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("customizeFactoryBean.xml");
        context.refresh();

        People people1 = (People) context.getBean("people");
        FactoryBean bean = (FactoryBean) context.getBean("&people");
        System.out.println("获得了 bean："+ people1.getName()+" 并且获得了 FactoryBean:"+ bean);
    }
}
